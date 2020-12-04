package Date.Nov.Nov21th2019;

import java.util.List;

/**
 * Created by apple on 11/21/19.
 */
public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            String sub = s.substring(i, s.length());
            for (String word: wordDict) {

                if (sub.startsWith(word)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[n];
    }
}
