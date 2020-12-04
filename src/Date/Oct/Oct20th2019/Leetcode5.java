package Date.Oct.Oct20th2019;

/**
 * Created by apple on 10/20/19.
 */
public class Leetcode5 {

    int start, d;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return s.substring(start, start + d);
    }

    public void helper(String s, int i, int j) {

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (j - i - 1 > d) {
            d = j - i - 1;
            start = i + 1;
        }
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        String s = "babad";
        leetcode5.longestPalindrome(s);
    }
}
