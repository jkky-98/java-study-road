package hello.proxy.config.v3_proxyfactory;

import hello.proxy.app.v1.*;
import org.springframework.context.annotation.Bean;

public class ProxyFactoryConfigV0 {

    @Bean
    public OrderRepositoryV1 orderRepositoryV1() {
        return new OrderRepositoryV1Impl();
    }

    @Bean
    public OrderServiceV1 orderServiceV1() {
        return new OrderServiceV1Impl(orderRepositoryV1());
    }

    @Bean
    public OrderControllerV1 orderControllerV1() {
        return new OrderControllerV1Impl(orderServiceV1());
    }
}
