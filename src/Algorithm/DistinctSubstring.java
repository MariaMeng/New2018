package Algorithm;

/**
 * Created by apple on 10/5/18.
 * 字符串最长无重复子串的长度
 */
public class DistinctSubstring {

    public int longestSubstring(String s) {
        // write code here
        if (s.length() <= 1) return s.length();
        int[] map = new int[128];
        int i = 0, j = 0, d = Integer.MIN_VALUE;

        while (j < s.length()) {
            if (++map[s.charAt(j++)] > 1)
                while (--map[s.charAt(i++)] < 1) ;
            d = Math.max(d, j - i);
        }
        return d;
    }
}
