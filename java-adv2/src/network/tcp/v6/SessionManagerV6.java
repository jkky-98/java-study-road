package network.tcp.v6;

import java.util.ArrayList;
import java.util.List;

// 동시성 처리 필요
public class SessionManagerV6 {

    private List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(SessionV6 session) {
        sessions.add(session);
    }

    public synchronized void remove(SessionV6 session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        // 세션을 모두 닫기
        for (SessionV6 session : sessions) {
            session.close();
        }
        sessions.clear();
    }
}
