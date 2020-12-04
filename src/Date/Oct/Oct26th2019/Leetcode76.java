package Date.Oct.Oct26th2019;

/**
 * Created by apple on 10/26/19.
 */
public class Leetcode76 {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null) return "";
        if (t.length() == 0) return s;

        int m = s.length(), n = t.length();
        int[] map = new int[256];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int i  = 0, left = 0;
        int d = Integer.MAX_VALUE, start = 0;
        int counter = n;
        while (i < m) {
            if (--map[s.charAt(i++)] >= 0) {
                counter--;
            }

            while (counter == 0) {

                if (d > i - left){
                    d = i - left;
                    start = left;
                }
                if (++map[s.charAt(left++)] > 0) {
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" :s.substring(start, start + d);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}
