public class client123 {
    public static void main(String[] args) {
        Printer1 printer1 = new Printer1();
        new Thread(() -> {

            for (int i = 1; i <= 100; i += 2) {
                printer1.printOdd(i);
            }

        }, "odd-thread").start();

        new Thread(() -> {

            for (int i = 2; i <= 100; i += 2) {
                printer1.printEven(i);
            }

        }, "even-thread").start();
    }
}
