package DP;

/**
 * Created by apple on 10/9/18.
 * �����ַ��� DP
 * https://www.lintcode.com/problem/interleaving-string/description
 *
 */
public class IsInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here

        if (s1 == null && s2 == null && s3 == null) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        int n = s1.length(), m = s2.length();

        // s1ǰi���ַ��Ӵ���s2ǰj���ַ��Ӵ�������ɽ����Ӵ�������£�
        // s3�ĵ�i + j + 1λ�ã��Ƿ�Ϊs1�е�i��λ�õ��ַ������� s2�е�j��λ�õ��ַ���
        boolean[][] dp = new boolean[n + 1][m + 1];


        dp[0][0] = true;
        for (int j = 1; j <= m; j++)
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 1; i <= n; i++)
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                dp[i][j] = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) || dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);

        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
    }

}
