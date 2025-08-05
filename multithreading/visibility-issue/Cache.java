import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final static Map<String , String> m = new HashMap<>();

    public void getData(String key) {
        String ans = m.get(key);
        System.out.println("Current Thread is" +Thread.currentThread().getName() + "ans is" + ans);
    }

    public static synchronized void update(String key , String value) {
        m.put(key , value);
    }
}
