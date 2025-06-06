package hello.proxy.config.v3_proxyfactory;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV2 {

    @Bean
    public Advisor logTraceAdvisor(LogTrace logTrace) {
        LogTraceAdvice logTraceAdvice = new LogTraceAdvice(logTrace);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut(), logTraceAdvice);
        return advisor;
    }

    @Bean
    public Pointcut pointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        return pointcut;
    }

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 target = new OrderControllerV2(orderServiceV2(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(logTraceAdvisor(logTrace));
        return (OrderControllerV2) proxyFactory.getProxy();
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 target = new OrderServiceV2(orderRepositoryV2(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(logTraceAdvisor(logTrace));
        return (OrderServiceV2) proxyFactory.getProxy();
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 target = new OrderRepositoryV2();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(logTraceAdvisor(logTrace));
        return (OrderRepositoryV2) proxyFactory.getProxy();
    }

}
