package task4;

public class Main{
    public static void main(String[] args) {
        AttemptCounter c = AttemptCounter.getInstance();
        System.out.println(c.count);
        c.getInstance();
        System.out.println(c.count);


    }
}