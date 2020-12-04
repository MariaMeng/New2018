package Date.Oct.Oct30th2019;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 10/30/19.
 */
public class Leetcode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) return new ArrayList<String>();

        List<String> res = new ArrayList<>();

        int[] sum = new int[words.length + 1];

        // 包含空白的字符和
        int totalSum = 0;
        int start = 1;
        int mul = 1;
        for (int i = 1; i <= words.length; i++) {
            if (i == 1) {
                totalSum += words[i - 1].length();
            } else
                totalSum += 1 + words[i - 1].length();

            sum[i] += sum[i - 1] + words[i - 1].length();
            if (totalSum / maxWidth > mul) {
                mul++;
                String str = makeLine(words, start - 1, i - 1,  sum[i - 1] - sum[start - 1]);
                res.add(str);
                start = i;
            }
        }
        return res;
    }

    public String makeLine(String[] words, int start, int end, int length) {
        int num = end - start;

        StringBuilder sb = new StringBuilder();

        if (end != words.length - 1) {
            if (start == end) {
                int pad = (length + 1) / 2;
                while (pad > 0) {
                    sb.append(" ");
                    pad--;
                }
                sb.append(words[start]);
                pad = length - pad;
                while (pad > 0) {
                    sb.append(" ");
                }

                return sb.toString();
            }
            int extra = length % num;
            int div = length / num;

            for (int i = start; i <= end; i++) {
                sb.append(i);
                if (extra-- > 0) {
                    sb.append(" ");
                }
                if (i < end) {
                    for (int j = 1; j <= div; j++) {
                        sb.append(" ");
                    }
                }
            }
        }
        return sb.toString();
    }
}
