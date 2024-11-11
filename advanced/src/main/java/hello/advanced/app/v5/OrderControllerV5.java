package hello.advanced.app.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.trace.template.LogTemplate;
import hello.advanced.trace.template.TemplateCallback;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(String itemId) {

        LogTemplate logTemplate = new LogTemplate(trace);
        logTemplate.execute(() -> {
            orderService.orderItem(itemId);
            return null;
        }, "OrderController.request()");
        return "ok";
    }
}
