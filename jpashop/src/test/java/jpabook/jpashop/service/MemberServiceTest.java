package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepositoryOld;

    @Test
    void 회원가입() {
    	// given
        Member member = new Member();
        member.setName("kim");

        // when
        Long saveId = memberService.join(member);

        // then
        assertThat(member).isEqualTo(memberRepositoryOld.findOne(saveId));
        // 왜 리포지토리를 써서 검증할까?
    }

    @Test
    void 중복_회원_예외() {
    	// given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        Long member1Id = memberService.join(member1);

        // then
        Assertions.assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 전체_회원_조회() {
    	// given
        Member m1 = new Member();
        Member m2 = new Member();
        Member m3 = new Member();

        m1.setName("geng");
        m2.setName("t1");
        m3.setName("dk");

        memberService.join(m1);
        memberService.join(m2);
        memberService.join(m3);
        // when
        List<Member> findMemberAll = memberRepositoryOld.findAll();
        // then
        assertThat(findMemberAll.size()).isEqualTo(3);
    }



}