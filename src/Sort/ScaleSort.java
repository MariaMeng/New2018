package Sort;

/**
 * Created by apple on 10/4/18.
 */
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        // write code here
        if (A == null || A.length == 0 || n < k) {
            return A;
        }
        int[] heap = getKHeap(A, k); // 建立大小为K的小根堆
        for (int i = k; i < n; i++) {
            A[i - k] = heap[0];
            heap[0] = A[i];
            heapify(heap, 0, k);
        }
        for (int i = n - k; i < n; i++) {
            A[i] = heap[0];
            swap(heap, 0, k - 1);
            heapify(heap, 0, --k);
        }
        return A;
    }

    public  int[] getKHeap(int[] A, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(heap, A[i], i);
        }
        return heap;
    }

    public  void heapInsert(int[] heap, int value, int index) {
        heap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] > heap[index]) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public  void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (arr[left] < arr[index]) {
                smallest = left;
            }
            if (right < heapSize && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                swap(arr, smallest, index);
            } else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public  void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
