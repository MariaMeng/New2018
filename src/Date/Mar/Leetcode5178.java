package Date.Mar;

import java.util.*;

/**
 * @author mengxiang
 * @date 20/3/22
 */
public class Leetcode5178 {
    int sum = 0;
    List<Integer> list = new LinkedList<>();
    public int sumFourDivisors(int[] nums) {
        int max = nums[0];
        for (int n: nums) {
            max = n > max ? n: max;
        }
        prim(max);
        for (int num: nums) {
            isValid(num);
        }
        return this.sum;
    }

    public void prim(int num) {
        for (int i = 2; i <=num ;i++) {
            boolean flag = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
    }

    public boolean isValid(int num) {
        int sum = 0;
        int acc = 1;
        if (num == 1) return false;
        if (list.contains(num)) return false;
        int idx = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (num != 1 && idx < list.size()) {
            int val = list.get(idx);
            int count = 1;
            while (num % val == 0) {
                count++;
                num /= val;
            }
            acc *= count;
            if (acc > 4) {
                return false;
            }
            if (count >1) {
                map.put(val, count);
            }
            idx++;
        }
        if (acc != 4)  return false;
        if (map.size() == 1) {
            int key = map.firstKey();
            sum = key * key * key * key - 1;
        }else {
            int first = map.firstKey();
            int second = map.lastKey();
            sum = 1 + first + second + first * second;
        }
        this.sum += sum;
        return true;
    }

    public static void main(String[] args) {
        Leetcode5178 ll = new Leetcode5178();
        int[] data = new int[]{21, 4, 7};
        int res = ll.sumFourDivisors(data);
        System.out.println(res);

        System.out.println((int)Math.sqrt(14));
    }
}
