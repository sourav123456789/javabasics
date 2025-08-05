import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client12345 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0 ; i < 3 ; i++) {
            executorService.submit(new Dependencies(latch));
        }
        latch.await();
        System.out.println("main thread is completed");
        executorService.shutdown();
    }
}
