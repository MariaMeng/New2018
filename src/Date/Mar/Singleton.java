package Date.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengxiang
 * @date 20/3/16
 */
public class Singleton {

    private static volatile Singleton instance;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ClassLoader classLoader = Singleton.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }

        String path = System.getProperty("java.class.path");
        System.out.println(path);
        List<Integer> res = new ArrayList<>();
        Arrays.sort(new int[]{2, 3});

    }

}
