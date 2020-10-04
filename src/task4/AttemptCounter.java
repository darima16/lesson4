package task4;

public class AttemptCounter {
    private static AttemptCounter instance;
    private int count;
    public static synchronized AttemptCounter getInstance() {
        if (instance==null) {
            instance = new AttemptCounter();
            instance.count = 0;
        }
        instance.count++;
        return instance;
    }

    public int getCount() {
        return count;
    }
}
