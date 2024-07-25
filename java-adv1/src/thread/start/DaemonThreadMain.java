package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // 데몬 스레드 여부
        daemonThread.start(); // main 스레드가 데몬 스레드 실행시킴
        System.out.println(Thread.currentThread().getName() + ": main() end");
        // 근데 데몬 스레드라 10초간 기다리는 것과 상관없이 user스레드 끝나서 그냥 자바 종료됨
    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");

            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
