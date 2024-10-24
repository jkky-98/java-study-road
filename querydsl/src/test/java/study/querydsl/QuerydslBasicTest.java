package study.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.dto.MemberDto;
import study.querydsl.dto.UserDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.QTeam;
import study.querydsl.entity.Team;

import java.util.List;

import static com.querydsl.jpa.JPAExpressions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QMember.member;
import static study.querydsl.entity.QTeam.team;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;


    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    public void startJPQL() {
        //member1을 찾아라.
        Member findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void startQuerydsl() {
        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void search() {

        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1").and(member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");


    }

    @Test
    public void sort() {
        em.persist(new Member(null, 100));
        em.persist(new Member("member5", 100));
        em.persist(new Member("member6", 100));

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        Member member5 = result.get(0);
        Member member6 = result.get(1);
        Member memberNull = result.get(2);
        assertThat(member5.getUsername()).isEqualTo("member5");
        assertThat(member6.getUsername()).isEqualTo("member6");
        assertThat(memberNull.getUsername()).isEqualTo(null);

    }

    @Test
    public void paging1() {
        List<Member> result = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetch();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void aggregation() {
        List<Tuple> result = queryFactory
                .select(member.count(),
                        member.age.sum(),
                        member.age.avg(),
                        member.age.max(),
                        member.age.min())
                .from(member)
                .fetch();

        Tuple tuple = result.get(0);
        assertThat(tuple.get(member.count())).isEqualTo(4);
        assertThat(tuple.get(member.age.sum())).isEqualTo(100);
        assertThat(tuple.get(member.age.avg())).isEqualTo(25);
        assertThat(tuple.get(member.age.max())).isEqualTo(40);
        assertThat(tuple.get(member.age.min())).isEqualTo(10);

    }

    /**
     * 팀의 이름과 각 팀의 평균 연령을 구해라.
     */
    @Test
    void group() {
        List<Tuple> result = queryFactory
                .select(team.name, member.age.avg())
                .from(member)
                .join(member.team, team)
                .groupBy(team.name)
                .fetch();
        // from member -> member 테이블 전체 조회
        // join(member.team, team) -> join team on member.team_id = team.id -> member의 team_id로 team을 조인함
        // groupBy(team.name) -> team.name을 기준으로 그룹화

        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);

        assertThat(teamA.get(team.name)).isEqualTo("teamA");
        assertThat(teamA.get(member.age.avg())).isEqualTo(15);

        assertThat(teamB.get(team.name)).isEqualTo("teamB");
        assertThat(teamB.get(member.age.avg())).isEqualTo(35);

    }

    @Test
    public void join() {
        List<Member> result = queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();
        // from member -> member 먼저 불러옴
        // join team on member.team_id = team.id -> member의 team_id로 team을 조인함
        // where -> join된 임시 테이블 기준으로 team.name이 teamA인 것들을 남김
        // select member -> 해당되는 모든 member 가져옴

        assertThat(result)
                .extracting("username")
                .containsExactly("member1", "member2");
    }

    /**
     * 회원과 팀을 조인하면서, 팀 이름이 teamA인 팀만 조인, 회원은 모두 조회
     */
    @Test
    public void join_on_filtering() {
        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(member.team, team).on(team.name.eq("teamA"))
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    @Test
    public void join_on_no_relation() {
        em.persist(new Member("teamA", 10));
        em.persist(new Member("teamB", 10));
        em.persist(new Member("teamC", 10));

        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }

    }

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    public void fetchJoinNo() {
        em.flush();
        em.clear();

        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("패치 조인 미적용").isFalse();
    }

    @Test
    public void fetchJoinUse() {
        em.flush();
        em.clear();

        Member findMember = queryFactory
                .selectFrom(member)
                .join(member.team, team).fetchJoin()
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("패치 조인 적용").isTrue();
    }

    /**
     * 나이가 가장 많은 회원 조회
     */
    @Test
    public void subQuery() {

        QMember memberSub = new QMember("memberSub");

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(
                        select(memberSub.age.max())
                                .from(memberSub)
                ))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(40);
    }

    /**
     * 나이가 평균 이상인 회원 조회
     */
    @Test
    public void subQueryAvgOver() {

        QMember memberAvg = new QMember("memberAvg");

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.goe(
                        select(memberAvg.age.avg())
                                .from(memberAvg)
                ))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(30, 40);


    }

    @Test
    public void subQueryIn() {

        QMember memberAvg = new QMember("memberAvg");

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.in(
                        select(memberAvg.age)
                                .from(memberAvg)
                                .where(memberAvg.age.gt(10))
                ))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(20, 30, 40);


    }

    @Test
    public void selectSubQuery() {
        QMember memberSub = new QMember("memberSub");

        List<Tuple> result = queryFactory
                .select(member.username,
                        select(memberSub.age.avg())
                                .from(memberSub)
                )
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    @Test
    public void basicCase() {
        List<String> result = queryFactory
                .select(member.age
                        .when(10).then("열살")
                        .when(20).then("스무살")
                        .otherwise("기타")
                )
                .from(member)
                .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    // 왠만하면 쓰지 말자~
    @Test
    public void complexCase() {
        List<String> result = queryFactory
                .select(new CaseBuilder()
                        .when(member.age.between(0, 20)).then("0~20살")
                        .when(member.age.between(21, 30)).then("성인")
                        .otherwise("기타"))
                .from(member)
                .fetch();
        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void constant() {
        List<Tuple> result = queryFactory
                .select(member.username, Expressions.constant("A"))
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    @Test
    public void concat() {
        List<String> fetch = queryFactory
                .select(member.username.concat("_").concat(member.age.stringValue()))
                .from(member)
                .where(member.username.eq("member1"))
                .fetch();

        for (String s : fetch) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void simpleProjection() {
        List<String> fetch = queryFactory
                .select(member.username)
                .from(member)
                .fetch();

        for (String s : fetch) {
            System.out.println("s = " + s);
        }
    }

    //tuple이 리포지토리 이상으로 넘어가면 좋지않다.
    //tuple은 querydsl에 종속적 바깥으로 갈때는 DTO
    @Test
    public void tupleProjection() {
        List<Tuple> result = queryFactory
                .select(member.username, member.age)
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            String username = tuple.get(member.username);
            Integer age = tuple.get(member.age);
            System.out.println("username = " + username);
            System.out.println("age = " + age);

        }
    }

    @Test
    public void findDtoByJpql() {
        List<MemberDto> resultList = em.createQuery("select new study.querydsl.dto.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                .getResultList();

        for (MemberDto memberDto : resultList) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findDtoBySetter() {
        List<MemberDto> fetch = queryFactory
                .select(Projections.bean(MemberDto.class, member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : fetch) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findDtoByField() {
        List<MemberDto> fetch = queryFactory
                .select(Projections.fields(MemberDto.class, member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : fetch) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findDtoByConstructor() {
        List<MemberDto> fetch = queryFactory
                .select(Projections.constructor(MemberDto.class, member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : fetch) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findUserDtoByField() {
        QMember memberSub = new QMember("memberSub");
        List<UserDto> fetch = queryFactory
                .select(Projections.fields(UserDto.class,
                        member.username.as("name"),
                        ExpressionUtils.as(JPAExpressions
                                .select(memberSub.age.max())
                                .from(memberSub), "age")
                ))
                .from(member)
                .fetch();

        for (UserDto userDto : fetch) {
            System.out.println("userDto = " + userDto);
        }
    }

    @Test
    public void dynamicQuery_BooleanBuilder() {
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember1(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember1(String usernameParam, Integer ageParam) {

        BooleanBuilder builder = new BooleanBuilder();

        if (usernameParam != null) {
            builder.and(member.username.eq(usernameParam));
        }

        if (ageParam != null) {
            builder.and(member.age.eq(ageParam));
        }

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(builder)
                .fetch();

        return result;
    }

    @Test
    public void dynamicQuery_WhereParam() {
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember2(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember2(String usernameParam, Integer ageParam) {
        return queryFactory
                .selectFrom(member)
                .where(usernameEq(usernameParam), ageEq(ageParam))
                .fetch();
    }

    private Predicate usernameEq(String usernameParam) {
        if (usernameParam == null) {
            return null;
        }
        return member.username.eq(usernameParam);
    }

    private Predicate ageEq(Integer ageParam) {
        if (ageParam == null) {
            return null;
        }
        return member.age.eq(ageParam);
    }

    @Test
    public void bulkUpdate() {
        long count = queryFactory
                .update(member)
                .set(member.username, "비회원")
                .where(member.age.lt(28))
                .execute();
        em.clear();
    }

    @Test
    public void sqlFunction() {
        List<String> fetch = queryFactory
                .select(Expressions.stringTemplate("function('replace', {0}, {1}, {2})", member.username, "member", "M"))
                .from(member)
                .fetch();

        for (String s : fetch) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void sqlFunction2() {
        List<String> fetch = queryFactory
                .select(member.username)
                .from(member)
                .where(member.username.eq(
                        member.username.lower()
                ))
                .fetch();

        for (String s : fetch) {
            System.out.println("s = " + s);
        }

    }
}
