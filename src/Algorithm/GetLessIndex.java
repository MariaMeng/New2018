package Algorithm;

/**
 * Created by apple on 10/30/18.
 * 已知数组中相邻数都不相等，返回任意一个局部最小值的位置。
 */
public class GetLessIndex {

    /**
     * 方法一：自己写的
     * @param arr
     * @return
     */
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        if (arr[0] < arr[1]) return 0;
        if (arr[n - 1] < arr[n - 2]) return n - 1;
        return helper(arr, 0, n - 1);
    }
    public int helper(int[] arr, int left, int right) {
        if (left < 0 || right >= arr.length || left >= right) return -1;
        if (right - left == 2) {
            if (arr[right] > arr[left])
                return left;
            else
                return right;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid])
            return mid;
        if (arr[mid - 1] > arr[mid]) {
            return helper(arr, mid + 1, right);
        } else
            return helper(arr, left, mid - 1);
    }

    /**
     * 方法二：标准答案
     * @param arr
     * @return
     */
    public int getLessIndex2(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        int n = arr.length;
        if (arr[0] < arr[1]) return 0;
        if (arr[n - 1] < arr[n - 2]) return n - 1;
        return helper2(arr, 1, n - 2);
    }
    public static int helper2(int[] arr, int start, int end) {
        if (start >= end) return start;
        int mid = start + (end - start) / 2;
        if (mid - 1 >= 0 && arr[mid] > arr[mid - 1])
            return helper2(arr, start, mid - 1);
        else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1])
            return helper2(arr, mid + 1, end);
        else return mid;
    }
}
