package hello.jdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={}, class={}", connection, connection.getClass());
            // H2 DB 드라이버는 Jdbc 표준 인터페이스의 구현체이다.
            // H2 DB 드라이버가 제공하는 H2 전용 커넥션인 Connection h2.jdbc.JdbcConnection을 준다.
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
