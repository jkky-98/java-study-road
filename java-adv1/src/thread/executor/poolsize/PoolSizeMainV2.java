package thread.executor.poolsize;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV2 {

    public static void main(String[] args) {
        // 위 아래 es1 과 es2는 같다.
        ExecutorService es1 = Executors.newFixedThreadPool(2);
        ExecutorService es2 = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        log("pool 생성");
        printState(es2);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es2.execute(new RunnableTask(taskName));
            printState(es2, taskName);
        }


    }
}
