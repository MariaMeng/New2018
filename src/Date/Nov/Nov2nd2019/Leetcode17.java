package Date.Nov.Nov2nd2019;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 11/2/19.
 */
public class Leetcode17 {

    static String[] dic = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length()== 0) return res;

        StringBuilder sb = new StringBuilder();
        helper(digits, 0, res, sb);
        return res;
    }

    public static void helper(String digits, int pos, List<String> res, StringBuilder sb) {
        if (pos >= digits.length()) {
            res.add(sb.toString());
            return ;
        }

        int idx = digits.charAt(pos)  - '0';
        String d = dic[idx];

        for (int i = 0; i < d.length(); i++) {
            sb.append(d.charAt(i));
            helper(digits, pos + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> res  = letterCombinations(str);
        System.out.println(res);

        str = "398";
        res = letterCombinations(str);
        System.out.println(res);
    }
}
