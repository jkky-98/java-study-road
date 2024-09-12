package thread.executor.test;

import thread.executor.future.FutureExceptionMain;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class NewOrderService {

    ExecutorService es = Executors.newFixedThreadPool(3);

    public void order(String orderNo) throws Exception {

        InventoryWork taskInventoryWork = new InventoryWork(orderNo);
        ShippingWork taskShippingWork = new ShippingWork(orderNo);
        AccountingWork taskAccountingWork = new AccountingWork(orderNo);

        List<Callable<Boolean>> taskWorks = List.of(taskInventoryWork, taskShippingWork, taskAccountingWork);

        List<Future<Boolean>> futures = es.invokeAll(taskWorks);

        for (Future<Boolean> future : futures) {
            if (future.get()) {
                continue;
            } else {
                log("일부 작업이 실패했습니다.");
                return;
            }
        }

        log("모든 주문 처리가 성공적으로 완료되었습니다.");
    }

    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;
        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() throws Exception {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class ShippingWork implements Callable<Boolean> {
        private final String orderNo;
        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() throws Exception {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;
        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() throws Exception {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
