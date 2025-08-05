import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SharedBuffer1 {

    private final Queue<Integer> q = new LinkedList<>();

    private final Semaphore p = new Semaphore(1);
    private final Semaphore c = new Semaphore(0);

    private volatile boolean isDone = false;


    public void producer(int no) {

        try {
            p.acquire();
            q.add(no);
            System.out.println("current Thread is" + Thread.currentThread().getName() + " producing " + no);
            if(no == 99) {
                isDone = true;
            }
            c.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void consumer() {
        try {
            while(true) {
                c.acquire();
                int no = q.poll();
                System.out.println("current Thread is" + Thread.currentThread().getName() + " consumer consuming " + no);
                if(isDone) {
                    break;
                }
                p.release();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
