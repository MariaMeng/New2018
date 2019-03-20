package Algorithm;

/**
 * Created by apple on 10/17/18.
 */
public class KAdd {
    public static void main(String[] args) {
        int k = 3;
        String a = "00011";
        String b = "00221";
        System.out.println(addition(k, a, b));

    }

    public static String addition(int k, String a, String b) {
        // Write your code here
        if (a == null || b == null) return null;
        int acc = 0, sum = 0;
        int n = a.length(), m = b.length();
        int A = a.length() - 1, B = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        if (a.charAt(A) == '0' && a.charAt(0) == '0' && A > 0 && B > 0 && b.charAt(B) == '0' && b.charAt(0) == '0') {
            for (int i = 0; i < Math.min(n, m); i++) {
                sb.append(0);
                return sb.toString();
            }
        }


        while (A >= 0 && B >= 0) {
            sum = (acc + a.charAt(A) - '0' + b.charAt(B) - '0') % k;
            sb.append(sum);
            acc = (acc + a.charAt(A) - '0' + b.charAt(B) - '0') / k;
            A--;
            B--;
            if (A >= 0 && B >= 0 && a.charAt(A) == '0' && b.charAt(B) == '0' && acc == 0 && a.charAt(0) == '0' && b.charAt(0) == '0' )
                return sb.reverse().toString();

        }

        while (A >= 0) {
            if (A > 0 && a.charAt(A) == '0' && a.charAt(0) == '0')
                break;
            sum = (acc + a.charAt(A) - '0') % k;
            acc = (acc + a.charAt(A) - '0') / k;
            sb.append(sum);
            A--;
        }

        while (B >= 0) {
            if (B > 0 && b.charAt(B) == '0' && b.charAt(0) == '0')
                break;
            sum = (acc + b.charAt(B) - '0') % k;
            acc = (acc + b.charAt(B) - '0') / k;
            sb.append(sum);
            B--;
        }
        if (acc != 0) {
            sum = acc;
            sb.append(sum);
        }


        sb.reverse();
        return sb.toString();
    }
}
