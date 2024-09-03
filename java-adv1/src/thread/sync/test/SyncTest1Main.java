package thread.sync.test;

public class SyncTest1Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        // 두 쓰레드에 대해서
        // count = count + 1;을 진행할 때 count값이 같은 것을 두 번
        thread1.join();
        thread2.join();
        System.out.println("결과: " + counter.getCount()); // main thread 실행 부분
    }
    static class Counter {
        private int count = 0;
        public synchronized void increment() {
            count = count + 1;
        }
        public int getCount() {
            return count;
        }
    }
}
