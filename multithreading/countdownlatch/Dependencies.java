import java.util.concurrent.CountDownLatch;

public class Dependencies implements Runnable {

    private final CountDownLatch latch;

    public Dependencies(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread is doing the task");
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
