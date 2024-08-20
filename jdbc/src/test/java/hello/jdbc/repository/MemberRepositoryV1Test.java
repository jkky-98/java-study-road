package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach() {
        // 기본 DriverManager
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        // 커넥션 풀링
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setPassword(PASSWORD);
        dataSource.setUsername(USERNAME);
        repository = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberV2", 10000);
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        assertThat(findMember).isEqualTo(member);

        //update
        repository.update("memberV2", 5000);
        Member memberV2 = repository.findById("memberV2");
        assertThat(memberV2.getMoney()).isEqualTo(5000);

        //remove
        repository.remove("memberV2");
        assertThatThrownBy(() -> repository.findById("memberV2"))
                .isInstanceOf(NoSuchElementException.class);
    }
}