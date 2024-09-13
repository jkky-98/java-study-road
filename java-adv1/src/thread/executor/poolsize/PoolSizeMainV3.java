package thread.executor.poolsize;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV3 {

    public static void main(String[] args) {
        ExecutorService es2 = Executors.newCachedThreadPool();

        log("pool 생성");
        printState(es2);

        for (int i = 1; i <= 100; i++) {
            String taskName = "task" + i;
            es2.execute(new RunnableTask(taskName));
            printState(es2, taskName);
        }


    }
}
