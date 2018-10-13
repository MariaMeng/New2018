package BinarySearch;

/**
 * Created by apple on 10/7/18.
 */
public class MinValue {
    public static int getMin(int[] arr, int n) {
        // write code here
        if (arr == null || n == 0) return -1;
        if (n == 1) return arr[0];

        return helper(arr, 0, n - 1);
    }
    public static int helper(int[] arr, int start, int end) {
        if (start == end) return arr[start];
        if (arr[start] < arr[end]) return arr[start];
        int mid = start + (end - start) / 2;
        if (mid - 1 >= 0 &&  arr[mid - 1] > arr[mid]) return arr[mid];
        if (arr[start] > arr[mid]) return helper(arr, start, mid - 1);
        else if (arr[mid] > arr[end]) return helper(arr, mid + 1, end);
        else return helper(arr, start, end - 1);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1};
        int n = 2;
        System.out.println(getMin(arr, n));
        System.out.println(Integer.toBinaryString(1000000007));
    }

}
