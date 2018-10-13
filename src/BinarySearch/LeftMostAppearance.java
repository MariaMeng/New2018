package BinarySearch;

/**
 * Created by apple on 10/6/18.
 */
public class LeftMostAppearance {
    public static int findPos(int[] arr, int n, int num) {
        // write code here
        if (n == 0) return -1;
        return helper(arr, 0, n - 1, num);
    }
    public static int helper(int[] arr, int start, int end, int num) {
        if (start > end) return -1;
        if (start == end) {
            if (arr[start] == num) return start;
            else return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == num && (mid == 0 || arr[mid - 1] < arr[mid])) return mid;
        else if (arr[mid] >= num) return helper(arr, start, mid - 1, num);
        else return helper(arr, mid + 1, end, num);
    }
    public static void main(String[] args) {
        int[] arr = {36,62,146,208,210,369,616};
        int n = 7;
        int num = 616;
        System.out.println(findPos(arr, n, num));
    }
}
