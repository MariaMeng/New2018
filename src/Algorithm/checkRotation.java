package Algorithm;

/**
 * Created by apple on 9/25/18.
 */
public class checkRotation {
    public static boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if (lena != lenb) return false;
        String total = A + A;
        System.out.println(total);
        System.out.println(B);
        return total.contains(B);
    }
    public static void main(String[] args) {
        System.out.println(chkRotation("RFSPUYLYR",9,"UYLYRRFSP",9));
    }
}
