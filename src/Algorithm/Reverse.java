package Algorithm;

import com.sun.deploy.util.StringUtils;

/**
 * Created by apple on 10/4/18.
 */
public class Reverse {
    public static String reverseSentence(String A, int n) {
        // write code here
        if (A == null) return null;
        if (A.length() <= 1) return A;
        String rev = reverse(A);
        String[] words = rev.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String w : words)
            sb.append(reverse(w) + " ");
        String res = sb.toString();
        return res.trim();
    }
    public static String reverse(String S) {
        int n = S.length();
        if (n == 0) return null;
        char[] sentense = S.toCharArray();
        int left = 0, right = n - 1;
        while (left < right)
            swap(sentense, left++, right--);
        return String.valueOf(sentense);
    }

    public static void swap(char[] sentense, int i, int j) {
        char tmp = sentense[i];
        sentense[i] = sentense[j];
        sentense[j] = tmp;
    }

    public static void main(String[] args) {
        String A = "TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB";
        int n = 47;
        System.out.println(reverseSentence(A, n));

    }
}
