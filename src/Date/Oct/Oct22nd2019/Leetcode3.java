package Date.Oct.Oct22nd2019;

/**
 * Created by apple on 10/22/19.
 */
public class Leetcode3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int i  =0;
        int n = s.length();
        int[] map = new int[256];
        int d = 0;

        int left = 0;
        while (i < n) {

            char c = s.charAt(i++);
            map[c]++;

            if (map[c] > 1) {

                while (--map[s.charAt(left++)] < 1) {
                }
            }

            d = Math.max(d, i - left);
        }
        return d;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);

        s = "  ";
        res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
