package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * JdbcTemplate 사용
 */
@Slf4j
public class MemberRepositoryV5 implements MemberRepository{
//
//    private final DataSource dataSource;
//    private final SQLExceptionTranslator exTranslator;
    private final JdbcTemplate template;

    public MemberRepositoryV5(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Member save(Member member) {
        String sql = "insert into member(member_id, money) values (?, ?)";
        template.update(sql, member.getMemberId(), member.getMoney());
        return member;

    }

    public Member findById(String memberId) {
        String sql = "select * from member where member_id = ?";
        return template.queryForObject(sql, memberRowMapper(), memberId);
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setMemberId(rs.getString("member_id"));
            member.setMoney(rs.getInt("money"));
            return member;
        };
    }

    public void update(String memberId, int money) {
        String sql = "update member set money=? where member_id=?";
        template.update(sql, money, memberId);
    }
    public void remove(String removeId) {
        String sql = "delete from member where member_id = ?";
        template.update(sql, removeId);
    }

//    private void close(Connection con, Statement stmt, ResultSet rs) {
//        JdbcUtils.closeResultSet(rs);
//        JdbcUtils.closeStatement(stmt);
//        // 주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야 한다.
//        DataSourceUtils.releaseConnection(con, dataSource);
//    }
//
//    private  Connection getConnection() throws SQLException {
//        // 주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야 한다.
//        Connection con = DataSourceUtils.getConnection(dataSource);
//        log.info("get connection={}, class={}", con, con.getClass());
//        return con;
//    }
}
