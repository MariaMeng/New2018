package Algorithm;

/**
 * Created by apple on 10/4/18.
 */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // write code here

        for (int i = 0; i < n; i++) {
            heapInsert(a, a[i], i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify(a, 0, i);
        }
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1])
                return true;
        }
        return false;
    }

    public  void heapInsert(int[] heap, int value, int index) {
        heap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] < heap[index]) {
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
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public  void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = sb.toString();

    }
}
