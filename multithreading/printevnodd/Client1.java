public class Client1 {
    public static void main(String[] args) {
        Printer p = new Printer();
        new Thread(() -> {
            for (int i = 0; i < 100; i = i + 2) {
                try {
                    p.printEven(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Even-thread").start();

        new Thread(() -> {
            for (int i = 1; i < 100; i = i + 2) {
                try {
                    p.printOdd(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "odd-thread").start();
    }
}
