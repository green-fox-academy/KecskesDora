package Counter;

public class Main {
    public static void main(String[] args) {
        Counter counter1 = new Counter (10);
        counter1.add();
        System.out.println(counter1.get());
        counter1.add(50);
        System.out.println(counter1.get());
        counter1.reset();
        System.out.println(counter1.get());
    }
}
