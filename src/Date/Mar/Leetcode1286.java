package Date.Mar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengxiang
 * @date 20/4/1
 */
class CombinationIterator {

    List<String> list;
    int idx = 0;

    public CombinationIterator(String characters, int combinationLength) {
        int n = combinationLength;
        list = new ArrayList<>();
        String strs = characters;
        backtrack(strs, 0, n, "", list);
    }

    public void backtrack(String strs, int idx, int n, String tmp, List<String> list) {
        if (n == 0) {
            list.add(tmp);
            return ;
        }
        if (idx >= strs.length()) {
            return ;
        }
        for (int i = idx; i < strs.length(); i++) {
            String str = tmp + strs.charAt(i);
            backtrack(strs, i + 1, n - 1, str, list);
        }

    }

    public String next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }
}
public class Leetcode1286 {
    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());

        out:
        for (int i = 0; i < 100; i++) {
            for (int j = 1; j < 10; j++) {
                break out;
            }
        }
    }
}
