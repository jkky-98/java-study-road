package collection.deque;

import java.util.Stack;

public class StackMain {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack = " + stack);

        System.out.println("stack.peek() = " + stack.peek());

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);

        // 스택은 사용하지 말자!!!!!!! -> 벡터를 사용하기 때문
    }
}
