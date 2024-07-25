package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {


        Thread counter5 = new Thread(new MyRunnable(500, "B"));
        counter5.setName("Thread-B");
        Thread counter10 = new Thread(new MyRunnable(1000, "A"));
        counter10.setName("Thread-A");
        counter5.start();
        counter10.start();
    }

    static class MyRunnable implements Runnable {
        private int sleepMs;
        private String content;

        public MyRunnable(int sleepMs, String content) {
            this.sleepMs = sleepMs;
            this.content = content;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };
}
