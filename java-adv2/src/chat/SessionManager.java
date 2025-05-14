package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static util.MyLogger.log;

public class SessionManager {

    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        // 세션을 모두 닫기
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public synchronized void sendAll(String message) {
        sessions.forEach(session ->
                {
                    try {
                        session.send(message);
                    } catch (IOException e) {
                        log(e);
                    }
                }
        );
    }

    public synchronized List<String> getAllUsername() {

        return sessions.stream()
                .map(Session::getUsername)
                .filter(Objects::nonNull)
                .toList();

    }
}
