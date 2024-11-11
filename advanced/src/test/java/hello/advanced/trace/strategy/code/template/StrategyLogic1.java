package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic1<T> implements Callback {
    @Override
    public T call() {
        log.info("비즈니스 로직1 실행");
        return null;
    }
}
