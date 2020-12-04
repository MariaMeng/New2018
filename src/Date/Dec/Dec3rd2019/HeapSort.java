package Date.Dec.Dec3rd2019;

/**
 * Created by apple on 12/4/19.
 */
public class HeapSort {

    public void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        int n = nums.length;
        heapify(nums, n - 1);
        int j = n - 1;
        while (j > 0) {
            swap(nums, 0, j);
            j--;
            if (j == 0) break;
            heapify(nums, j);
        }
    }

    public void heapify(int[] nums, int lastIdx) {
        int j = (lastIdx - 1) / 2;
        while (j >=  0) {
            adjustHeap(nums, j, lastIdx);
            j--;
        }
    }

    public void adjustHeap(int[] nums, int root, int lastIdx) {
        int childL = 2 * root + 1;
        int childR = 2 * root + 2;

        int idx = root;
        if (childR <= lastIdx) {
            if (nums[root] <  nums[childR] || nums[root] < nums[childL]) {
                idx = nums[childR] > nums[childL]? childR: childL;
            }
        } else if (childL <= lastIdx) {
            if (nums[root] < nums[childL]) {
                idx = childL;
            }
        }

        if (idx != root) {
            swap(nums, idx, root);
            adjustHeap(nums, idx, lastIdx);
        }
    }


    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        int[] nums = new int[] {11, 22, 5, 0};
        heap.heapSort(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }
}
