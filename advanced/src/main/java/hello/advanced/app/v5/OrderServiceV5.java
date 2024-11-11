package hello.advanced.app.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.trace.template.LogTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        LogTemplate logTemplate = new LogTemplate(trace);
        logTemplate.execute(() -> {
            orderRepository.save(itemId);
            return null;
        }, "OrderService.orderItem()");
    }
}
