package hello.aop.exam.aop;

import hello.aop.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class RetryAspect {

    @Around("@annotation(retry)")
    public Object doRetryException(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        int maxRetry = retry.maxRetry();
        Exception exceptionHolder = null;

        for (int i = 0; i < maxRetry; i++) {
            try {
                return joinPoint.proceed();
            }  catch (Exception e) {
                if (i == maxRetry - 1) {
                    throw e;
                } else {
                    exceptionHolder = e;
                    log.info("[Retry] {} , Exception {}, Retry count : {}",joinPoint.getSignature(), exceptionHolder, (i + 1));
                }
            }
        }

        return null;
    }
}
