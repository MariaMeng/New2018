package Date.Dec.Dec2nd2019;

/**
 * Created by apple on 12/2/19.
 */
public class HeapSort {

    public void heapSort(int[] num) {
        if (num == null || num.length == 0) return ;

        int n = num.length;
        heapify(num, n - 1);
        int j = n - 1;
        while (j > 0) {
            swap(num, 0, j);
            j--;
            if (j == 0) break;
            adjustHeap(num, 0, j);
        }
    }

    public void heapify(int[] num, int lastIdx) {
        int j = (lastIdx) / 2;
        while (j >= 0) {
            int root = j;
            adjustHeap(num, root, lastIdx);
            j--;
        }
    }

    public void adjustHeap(int[] num, int root, int lastIdx) {
        int i = root;
        int childL = 2 * i;
        int childR = 2 * i + 1;
        if (childR <= lastIdx) {
            if (num[root] < num[childL] || num[root] < num[childR]) {
                i = num[childR] > num[childL]? childR: childL;
            }
        } else if (childL <= lastIdx) {
            if (num[root] < num[childL]) {
                i = childL;
            }
        }

        if (i != root) {
            swap(num, i, root);
            adjustHeap(num, i, lastIdx);
        }
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }


    public int[] heapSort(int[] A, int n) {
        int lastIndex = n - 1;
        buildMaxHeap(A, lastIndex);//建立最大堆
        while(lastIndex > 0){
            swap(A, 0, lastIndex);
            if(--lastIndex == 0)//只剩一个元素，就不用调整堆了，排序结束
                break;
            adjustHeap(A,0,lastIndex);
        }
        return A;
    }
    public void buildMaxHeap(int[] arr, int lastIndex) {
        // 从最后一个元素的父节点开始进行调整，一直调整到根节点结束
        int j = (lastIndex - 1) / 2;
        while (j >= 0) {
            int rootIndex = j;
            adjustHeap(arr, rootIndex, lastIndex);
            j--;
        }
    }
    public void adjustHeapB(int[] arr, int rootIndex, int lastIndex) {//从根节点开始往下调整
        int biggerIndex = rootIndex;
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        if(rightChildIndex <= lastIndex){//如果右孩子存在，则左孩子一定存在
            if(arr[rightChildIndex] > arr[rootIndex] || arr[leftChildIndex] > arr[rootIndex]){
                //将子节点更大的元素下标赋值给biggerIndex
                biggerIndex = arr[rightChildIndex] > arr[leftChildIndex]?rightChildIndex:leftChildIndex;
            }
        }
        else if(leftChildIndex <= lastIndex){//保证左孩子存在，且不能越界
            if(arr[leftChildIndex] > arr[rootIndex]){
                biggerIndex = leftChildIndex;
            }
        }
        if(biggerIndex != rootIndex){
            swap(arr, biggerIndex, rootIndex);
            adjustHeap(arr, biggerIndex, lastIndex);
        }
    }
    public void swapB(int[] arr, int biggerIndex, int rootIndex) {
        int temp = arr[rootIndex];
        arr[rootIndex] = arr[biggerIndex];
        arr[biggerIndex] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[] {5, 3, 8, 11, 100, -234, -2};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

        data = new int[] {5, 3, 8, 11};
        heapSort.heapSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

    }

    public void heapSort2(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        int n = nums.length;
        heapify2(nums, n - 1);
        int j = n - 1;
        while (j > 0) {
            swap(nums, 0, j);
            j--;
            if (j == 0) break;
            heapify2(nums, j);
        }
    }

    public void heapify2(int[] nums, int lastIdx) {

    }



}
