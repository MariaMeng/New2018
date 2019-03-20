package ObjectOriented.SingleTon;

/**
 * Created by apple on 10/18/18.
 */
public class Singleton1 {
    private volatile static Singleton1 ourInstance ;
    private Singleton1() {}


    public static Singleton1 getInstance() {

        if (ourInstance == null) {
            synchronized (Singleton1.class) {
                if (ourInstance == null) {
                    ourInstance = new Singleton1();
                }
            }
        }

        return ourInstance;
    }
    public static int getHash(Singleton1 ourInstance) {
        return ourInstance.hashCode();
    }

}
