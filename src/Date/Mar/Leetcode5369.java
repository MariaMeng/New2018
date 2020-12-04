package Date.Mar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengxiang
 * @date 20/3/29
 */
public class Leetcode5369 {
    public int numTeams(int[] rating) {
        if (rating == null || rating.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        return dfs(rating, 0, 3, list);
    }
    public int dfs(int[] rating, int idx, int left, List<Integer> list) {
        if (left == 0) return 1;
        if (idx == rating.length) return 0;
        int res =0;
        for (int i = idx; i < rating.length; i++) {
            int size = list.size();
            boolean isValid = false;
            if (size == 0) {
                isValid = true;
            }
            else if (size == 1) {
                if (rating[i] != rating[list.get(0)]) {
                    isValid = true;
                }
            }
            else if (size == 2) {
                if (rating[list.get(0)] < rating[list.get(1)] && rating[list.get(1)] < rating[i]) {
                    isValid = true;
                }
                else if (rating[list.get(0)] > rating[list.get(1)] && rating[list.get(1)] > rating[i]) {
                    isValid = true;
                }
            }

            if (isValid){
                list.add(i);
                res += dfs(rating, i + 1, left - 1, list);
                list.remove(list.size() - 1);
            }
        }
        return res;
    }
}
