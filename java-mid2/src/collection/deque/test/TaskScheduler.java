package collection.deque.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskScheduler {
    Deque<Task> deque = new ArrayDeque<>();


    public void addTask(Task compressionTask) {
        deque.offer(compressionTask);
    }


    public int getRemainingTasks() {
        return deque.size();
    }


    public void processNextTask() {
        Task task = deque.poll();
        task.execute();
    }
}
