package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();

        callback.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
