package hello.aop.order.aop.exam;

import hello.aop.exam.ExamService;
import hello.aop.exam.aop.RetryAspect;
import hello.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import({TraceAspect.class, RetryAspect.class})
class ExamServiceTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 11; i++) {
            log.info("client reqeust i={}", i);
            examService.request("data" + i);
        }
    }
}