package Google;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by apple on 10/21/18.
 */
public class Solution {
    public static void main(String[] args) throws  Exception{
        Scanner in = new Scanner(System.in);

        String path = "out1.txt";
        File file = new File(path);

        FileWriter fw  = new FileWriter(file);

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            if (t == 8)
                System.out.println(t);
            int N = in.nextInt();
            int[] data = new int[N];
            for (int i = 0; i < N; i++) {
                data[i] = in.nextInt();
            }

            int res = findTripple(data);

            fw.write("Case #" + t + ": " + res);
            if (t != T) {
                fw.write("\n");
            }
        }
        fw.close();


//        int [] nunms = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 7};
//        int res = binarySearchLeft(nunms, 0, 10, 3);
//        int resR = binarySearchRight(nunms, 0, 10, 3);

    }
    public static int findTripple(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int acc = 0;
        int zeros = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                zeros++;
                continue;
            }
            for (int j = 0; j < i - 1; j++) {
                if (nums[j] == 0) continue;
                if (nums[i] % nums[j] != 0) continue;

                int tmp = nums[i] / nums[j];
                if (tmp < nums[j]) continue;
                int resL = binarySearchLeft(nums, j + 1, i - 1, tmp);
                int resR = binarySearchRight(nums, j + 1, i - 1, tmp);
                if (resL != -1 && resR != -1)
                    acc+= resR - resL + 1;
            }
        }

        acc += factor(zeros, 3) / 6;

        return acc;
    }

    public static int factor(int val ,int k) {
        int res = 1;
        while (k-- != 0) {
            res *= val;
            val -= 1;
        }
        return res;
    }

    public static int binarySearchLeft(int[] nums, int left, int right, int tmp) {
        if (left > right) return -1;
        if (left == right)
            if (nums[left] == tmp)
                return left;
            else return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == tmp && (mid == left || nums[mid - 1] != tmp)) {
            return mid;
        }
        else if (nums[mid] >= tmp) {
            return binarySearchLeft(nums, left, mid - 1, tmp);
        }
        else
            return binarySearchLeft(nums, mid + 1, right, tmp);
    }
    public static int binarySearchRight(int[] nums, int left, int right, int tmp) {
        if (left > right) return -1;
        if (left == right) {
            if (nums[right] == tmp)
                return right;
            else return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == tmp && (mid == right || nums[mid + 1] != tmp )) {
            return mid;
        } else if (nums[mid] <= tmp)
            return binarySearchRight(nums, mid + 1, right, tmp);
        else
            return binarySearchRight(nums, left, mid - 1, tmp);
    }
}
