package thread.volatille1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatilleCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("flag = " + task.runFlag + ", count = " + task.count + " in while()");
        log("main 종료");
    }

    static class MyTask implements Runnable {

//        boolean runFlag = true;
//        long count = 0;

        volatile boolean runFlag = true; // 캐시 메모리 사용하지 않음.
        volatile long count;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                count++;
                if (count % 100_000_000 == 0) {
                    log("flag = " + runFlag + ", count = " + count + " in while()");
                }

            }

            log("flag = " + runFlag + ", count = " + count + " 종료");
        }
    }
}
