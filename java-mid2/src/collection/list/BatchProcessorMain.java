package collection.list;

public class BatchProcessorMain {
    public static void main(String[] args) {

        BatchProcessor processor = new BatchProcessor(new MyArrayList<Integer>());
        processor.logic(100_000);

        BatchProcessor processor1 = new BatchProcessor(new MyLinkedList<Integer>());
        processor1.logic(100_000);
    }
}
