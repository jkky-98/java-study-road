package hello.proxy.pureproxy.concreteproxy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TimeProxy extends ConcreateLogic {

    private final ConcreateLogic concreateLogic;

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();

        String result = concreateLogic.operation();

        long endTime = System.currentTimeMillis();
        log.info("TimeDecorator 종료 resultTime = {}ms", endTime-startTime);
        return result;
    }
}
