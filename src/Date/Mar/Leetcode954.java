package Date.Mar;

import java.util.*;

/**
 * @author mengxiang
 * @date 20/3/21
 */
public class Leetcode954 {

    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        for (int b: B) {
            if (map.get(b) == 0) continue;
            if (map.getOrDefault(2 * b, 0) == 0) return false;

            map.put(b, map.get(b) - 1);
            map.put(b *2, map.get(2 * b) - 1);
        }
        return true;
    }
}
