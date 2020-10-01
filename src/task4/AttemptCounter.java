package task4;

public class AttemptCounter {
    private static AttemptCounter instance;
    public int count;
    public static synchronized AttemptCounter getInstance() {
        if (instance==null) {
            instance = new AttemptCounter();
            instance.count = 0;
        }
        instance.count++;
        return instance;
    }
}
