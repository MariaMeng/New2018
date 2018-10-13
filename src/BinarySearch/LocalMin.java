package BinarySearch;

/**
 * Created by apple on 10/6/18.
 */
public class LocalMin {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        int n = arr.length;
        if (arr[0] < arr[1]) return 0;
        if (arr[n - 1] < arr[n - 2]) return n - 1;
        return helper(arr, 1, n - 2);
    }
    public static int helper(int[] arr, int start, int end) {
        if (start >= end) return start;
        int mid = start + (end - start) / 2;
        if (mid - 1 >= 0 && arr[mid] > arr[mid - 1])
            return helper(arr, start, mid - 1);
        else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1])
            return helper(arr, mid + 1, end);
        else return mid;
    }
    public static int getLessIndex_B(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,9,2,1,4,0,10,9,0,8,3,5,6,7,1,9,2,4,0,7};
        int res = getLessIndex_B(arr);
        System.out.println(res);
    }

}
