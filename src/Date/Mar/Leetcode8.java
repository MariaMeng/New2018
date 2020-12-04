package Date.Mar;

/**
 * @author mengxiang
 * @date 20/3/9
 */
public class Leetcode8 {
    public static void main(String[] args) {
        String str = "42";
        int res = myAtoi(str);
        System.out.println(res);
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;

        // 首位字符是否为正负号
        int idx = 0;
        char[] data = str.toCharArray();

        boolean isValid = isValid(data[idx]);
        if (!isValid) return 0;


        int sign = 1;
        if (data[idx] == '-') {
            sign = -1;
            idx++;
        } else if (data[idx] == '+'){
            idx++;
        }

        int num = 0;

        while (idx < data.length) {
            boolean isDigit = isDigit(data[idx]);
            if (!isDigit) return 0;
            int digit = data[idx] - '0';
            if (sign > 0) {
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            } else {
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 8)) return 0;
            }

            num = num * 10 + digit;
            idx++;
        }
        return num * sign;
    }

    public static boolean isDigit(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) return true;
        return false;
    }

    public static boolean isValid(char c) {
        if (c == '+' || c == '-') return true;
        if (c - '0' >= 0 && c - '0' <= 9) return true;
        return false;
    }

    private int[] wait(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int n = nums.length;

        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
