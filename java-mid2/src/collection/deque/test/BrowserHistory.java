package collection.deque.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private final Deque<String> deque = new ArrayDeque<>();

    public void visitPage(String url) {
        deque.push(url);
        System.out.println("방문 : " + url);
    }

    public String goBack() {
        String nextUrl = deque.pop();
        System.out.println("뒤로 가기: " + nextUrl);
        return nextUrl;
    }
}
