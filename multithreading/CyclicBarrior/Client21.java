import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client21 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0 ; i <= 4 ; i++) {
            executorService.submit(() -> {
                System.out.println("Thread is" + Thread.currentThread().getName() + "waiting at barrior");
                try {
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                    System.out.println("Thread is" + Thread.currentThread().getName() + "doing task");
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            } , "Thread" + i);
        }

        System.out.println("Main thread completes");
        executorService.shutdown();

    }
}
