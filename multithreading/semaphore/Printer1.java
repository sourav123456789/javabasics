import java.util.concurrent.Semaphore;

public class Printer1 {

    private final Semaphore even = new Semaphore(0 , true);
    private final Semaphore odd = new Semaphore(1);

    public void printEven(int no) {


        try {
            even.acquire();
            System.out.println("current Thread is"
                    + Thread.currentThread().getName() + " " + "printing" + no);
            Thread.sleep(500);
            odd.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void printOdd(int no) {
        try {
            odd.acquire();
            System.out.println("current Thread is"
                    + Thread.currentThread().getName() + " " + "printing" + no);
            Thread.sleep(500);
            even.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
