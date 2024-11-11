package hello.advanced.trace.strategy.code.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextV1 {

    private static final Logger log = LoggerFactory.getLogger(ContextV1.class);
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
