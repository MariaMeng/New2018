package Date.Oct.Oct28th2019;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 10/28/19.
 */
public class Leetcode22 {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();
        char[] ch = new char[n * 2];
        backtrack(n, list, 0, 0, ch);

        return list;
    }

    public static void backtrack(int n, ArrayList<String> list, int first, int second, char[] ch) {
        if (second == n) {
            list.add(new String(ch));
            return ;
        }

        if (first < n) {
            ch[first + second] = '(';
            backtrack(n, list, first + 1, second, ch);
        }
        if (second < first) {
            ch[first + second] = ')';
            backtrack(n, list, first, second + 1, ch);
        }
    }

    public static void main(String[] args) {
        int n = 3 ;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }

}
