package Algorithm;

/**
 * Created by apple on 10/10/18.
 */
public class topK {
    public static int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] heap = getHeap(nums, k);
        for (int i = k; i < n; i++) {
            nums[i - k] = heap[0];
            heap[0] = nums[i];
            heapAdjust(heap, 0, k);
        }

        int start = k - 1;
        for (int i = n - k; i < n; i++) {
            swap(heap, 0, --k);
            heapAdjust(heap, 0, k);
        }
        return heap;
    }
    public static int[] getHeap(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++)
            insertHeap(heap, i, nums[i]);

        return heap;
    }
    public static void insertHeap(int[] heap, int idx, int val) {
        heap[idx] = val;
        int par;
        while (idx > 0) {
            par = (idx - 1) / 2;
            if (heap[par] > val) {
                swap(heap, idx, par);
                idx = par;
            } else
                break;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void heapAdjust(int[] heap, int idx, int len) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        while (left < len ) {
            int minIndex = idx;
            if (heap[left] < heap[idx])
                minIndex = left;
            if (right < len && heap[right] < heap[minIndex])
                minIndex = right;
            if (minIndex == idx)
                break;
            else {
                swap(heap, minIndex, idx);
                idx = minIndex;
                left = 2 * idx + 1;
                right = 2 * idx + 2;
            }
        }
    }
    public static void main(String[] ars) {
        int[] test = {1,2,3,4,5,6,8,9,10,7};
        int[] res = topk(test, 10);
        for (int r : res)
            System.out.println(r);
    }

}
