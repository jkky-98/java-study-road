package hello.proxy.pureproxy.concreteproxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcreateClient {

    private final ConcreateLogic concreateLogic;

    public void execute() {
        concreateLogic.operation();
    }
}
