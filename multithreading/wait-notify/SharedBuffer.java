import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int no) throws InterruptedException {
        System.out.println("producer is producing");
        while (buffer.size() == capacity) {
            System.out.println("Buffer full. Producer waiting...");
            wait();
        }
        buffer.add(no);
        System.out.println("Produced: " + no);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty. Consumer waiting...");
            wait();
        }
        int val = buffer.poll();
        System.out.println("Consumed: " + val);
        notify();
    }
}
