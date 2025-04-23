public class Client {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();
        new Thread(() -> {
            int i = 0;
            while (i <= 100) {
                try {
                    sharedBuffer.produce(i++);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                try {
                    sharedBuffer.consume();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
