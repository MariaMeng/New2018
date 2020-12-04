package Date.Mar;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author mengxiang
 * @date 20/3/29
 */
public class Leetcode5368 {
    public int findLucky(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (key == val) {
                return val;
            }
        }
        return -1;
    }
}
