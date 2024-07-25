package thread.start.test;

public class StartTest2Main {

    public static void main(String[] args) {
        CounterRunnable counterRunnable = new CounterRunnable();
        Thread counter = new Thread(counterRunnable);
        counter.setName("counter");
        counter.start();
    }
}
