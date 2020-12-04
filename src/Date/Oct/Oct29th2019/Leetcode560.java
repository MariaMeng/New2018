package Date.Oct.Oct29th2019;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 10/29/19.
 */
public class Leetcode560 {
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else
                map.put(sum, 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {

            Integer num = map.get(k + entry.getKey());
            if (num != null && num > 0) {
                res += entry.getValue() * num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[] {2, 3, -1, 0, -1, 5, 3, 0, 6, 0, 8};
        int K = 6;
        int res = subarraySum(data, K);
        System.out.println(res);
    }
}
