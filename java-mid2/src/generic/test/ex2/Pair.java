package generic.test.ex2;

public class Pair <T,T1> {
    private T First;
    private T1 Second;

    public void setFirst(T first) {
        First = first;
    }

    public void setSecond(T1 second) {
        Second = second;
    }

    public T getFirst() {
        return First;
    }

    public T1 getSecond() {
        return Second;
    }
}
