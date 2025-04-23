public class Printer {


    public synchronized void printEven(int no) throws InterruptedException {
        if (no % 2 != 0) {
            wait();
        }

        System.out.println("Even: " + no);
        notify();
        if(no < 99) {
            wait();
        }

    }

    public synchronized void printOdd(int no) throws InterruptedException {
        if (no % 2 == 0) {
            wait();
        }

        System.out.println("Odd: " + no);
        notify();
        if(no < 99) {
            wait();
        }


    }
}
