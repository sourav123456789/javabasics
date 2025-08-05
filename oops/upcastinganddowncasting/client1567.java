public class client1567 {
    public static void main(String[] args) {
        B b = new B();
        b.run();
        b.walk();
        System.out.println("================");
        A a = new A();
        a.run();
        System.out.println("================");
        A a1 = new B();
        a1.run();
        System.out.println("================");
    }
}
