package MIOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 12/23/18.
 */
public class Banana {

    /**
     * 已引入：
     * java.util.*
     * 要使用其他 jar 包请使用完整路径，如：
     * java.util.List<java.util.List<Integer>> list = new java.util.ArrayList<java.util.List<Integer>>(100);
     * @param  line 为单行测试数据
     * @return 处理后的结果
     */
    private static String solution(String line) {
        // please write your code here
        if (line == null || line.length() == 0) return null;
        String[] str = line.split(" ");
        int len = str.length;
        if (len == 0) return null;
        int[] data = new int[len];

        for (int i = 0; i < len; i++) {
            data[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(data);
        int max = 0;
        for (int i = 0 ; i < len; i++) {
            if (data[i] != 0)
                max = Math.max(max, data[i] * (len - i));
        }

        return String.valueOf(max);
        // return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        while (in.hasNextLine()) {
            str = in.nextLine();
            System.out.println(solution(str));
        }
    }

}
