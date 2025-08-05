import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> q = new LinkedBlockingQueue<>(10);
        final boolean[] isProducerCompleted = new boolean[1];

        new Thread(() -> {
            for(int i = 0 ; i < 20 ; i++) {
                try {
                    System.out.println("current Thread is" + Thread.currentThread().getName() + " producing" + i);
                    Thread.sleep(500);
                    q.put(i);
                    if(i == 19) {
                        isProducerCompleted[0] = true;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        } , "producer").start();

        new Thread(() -> {
            try {
                while(true) {
                    System.out.println("current Thread is" + Thread.currentThread().getName() + " trying to consume");
                    Thread.sleep(500);
                    int no = q.take();
                    System.out.println("current Thread is" + Thread.currentThread().getName() + " consumed " + no);
                    if(isProducerCompleted[0]) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } , "consumer").start();



    }
}
