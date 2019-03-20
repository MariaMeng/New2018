package MIOJ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by apple on 12/24/18.
 *
 * 输入一个乱序的连续数列，输出其中最长连续数列长度，要求算法复杂度为 O(n) 。

 输入
 54,55,300,12,56

 输出
 3

 输入样例
 100,4,200,1,3,2
 54,55,300,12
 1
 5,4,3,2,1
 1,2,3,4,5,6

 输出样例
 4
 2
 1
 5
 6
 */
public class LongestContinousArray {


    private static String solution(String line) {
        // please write your code here
        if (line == null || line.length() == 0) return null;
        String[] str = line.split(",");
        int len = str.length;
        if (len == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < len; i++) {
            int data = Integer.parseInt(str[i]);
            if (map.containsKey(data)) continue;

            int left = map.containsKey(data - 1) ? map.get(data - 1) : 0;
            int right = map.containsKey(data + 1) ? map.get(data + 1) : 0;

            int sum = 1 + left + right;
            map.put(data, sum);
            max = Math.max(max, sum);

            map.put(data - left, sum);
            map.put(data + right, sum);

        }
        return String.valueOf(max);
        // return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            System.out.println(solution(str));
        }
    }
}
