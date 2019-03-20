package Test;

/**
 * Created by apple on 10/30/18.
 */
public class testFinally {
    public static void main(String[] args) {
        System.out.println(test1());
    }
    public static int test1() {
        int res = 5;
        try {
            res++;
            throw new NullPointerException();

        }catch(Exception e) {
            res++;

            System.out.println(Thread.interrupted());
            System.out.println(Thread.interrupted());
            return res;
        } finally {
            res += 100;
            return res;
        }
    }

}
