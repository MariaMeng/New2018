package Algorithm;

/**
 * Created by apple on 10/19/18.
 */
public class CanFinish {
    static long i = 0;
    public static long canAccept(long n, int k) {
        // Write your code here
        double tmp = (double)(n * 2 / k);
//        System.out.println(tmp < Long.MAX_VALUE);
//        double left = 1, right = tmp;
//        long ans = 0;
//        while (left < right) {
//            double mid = left + (right - left) / 2;
//            if (mid <= tmp / (mid)) {
//                left = mid + 1;
//                ans = (long)(mid);
//            } else {
//                right = mid - 1;
//            }
//        }

        long ans = (long)Math.sqrt(tmp);
        return  (ans < (long)(tmp / ans)) ? ans : ans - 1;


    }
    public static void main(String[] args) {
        long n = 2105843009213610000L;
        long nn = 2105843009213610000L;
        System.out.println((int)Math.sqrt(nn * 2));
        int k = 5;
        long test1 = 100;

        System.out.println(canAccept(test1, k));
    }

}
