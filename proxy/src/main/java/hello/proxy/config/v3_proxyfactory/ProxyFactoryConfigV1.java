package hello.proxy.config.v3_proxyfactory;

import hello.proxy.app.v1.*;
import hello.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV1 {

    @Bean
    public DefaultPointcutAdvisor logTraceAdvisor(LogTrace logTrace) {
        LogTraceAdvice logTraceAdvice = new LogTraceAdvice(logTrace);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut(), logTraceAdvice);
        return advisor;
    }

    @Bean
    public NameMatchMethodPointcut pointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        return pointcut;
    }

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        OrderControllerV1 target = new OrderControllerV1Impl(orderServiceV1(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(logTraceAdvisor(logTrace));
        return (OrderControllerV1) proxyFactory.getProxy();
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        OrderServiceV1 target = new OrderServiceV1Impl(orderRepositoryV1(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(logTraceAdvisor(logTrace));
        return (OrderServiceV1) proxyFactory.getProxy();
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
        OrderRepositoryV1 target = new OrderRepositoryV1Impl();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(logTraceAdvisor(logTrace));
        return (OrderRepositoryV1) proxyFactory.getProxy();
    }

}
