package hello.proxy.config.v3_proxyfactory;

import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@RequiredArgsConstructor
public class LogTraceProxyProcessor implements BeanPostProcessor {

    private final Advisor logTraceAdvisor;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ProxyFactory proxyFactory = new ProxyFactory(bean);
        proxyFactory.addAdvisor(logTraceAdvisor);
        return proxyFactory.getProxy();
    }
}
