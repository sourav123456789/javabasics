public class Client1234 {
    public static void main(String[] args) {
        SharedBuffer1 sharedBuffer1 = new SharedBuffer1();
        new Thread(() -> {

            for (int i = 0 ; i < 100 ; i++) {
                sharedBuffer1.producer(i);
            }

        } , "producer").start();

        new Thread(sharedBuffer1::consumer, "consumer").start();


    }
}
