package Date.Nov.Nov2nd2019;

/**
 * Created by apple on 11/2/19.
 */
public class Leetcode10 {

    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                if (dp[0][j - 1] || (j - 2 >= 0 && dp[0][j - 2])) {
                    dp[0][j] = true;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {

        String s = "aab";
        String p = "c*a*b";

        boolean res = isMatch(s, p);
        System.out.println(res);

        s = "aa";
        p = "a*";
        res = isMatch(s, p);
        System.out.println(res);

        s = "ab";
        p = ".*";
        res = isMatch(s, p);
        System.out.println(res);

        s = "mississippi";
        p = "mis*is*p*.";
        res = isMatch(s, p);
        System.out.println(res);

        s = "aaa";
        p = "ab*ac*a";
        res = isMatch(s, p);
        System.out.println(res);

    }
}
