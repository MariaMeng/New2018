package Sort;

/**
 * Created by apple on 9/29/18.
 */
public class HeapSort {
//    public static int[] heapSort(int[] A, int n) {
//        // write code here
//        for (int i = n / 2; i >= 0; i--){
//            heapAdjust(A, i, n);
//        }
//
//        for (int i = n - 1; i > 0; i--){
//            swap(A,0, i);
//            heapAdjust(A,0, i);
//        }
//        return A;
//    }
//
//    static void heapAdjust(int[] A, int index, int length){
//        int childLeft;
//        int temp = A[index];
//        for( ; index * 2 + 1 < length; index = childLeft){
//            childLeft = index * 2 + 1;
//
//            if(childLeft != length - 1 && A[childLeft] < A[childLeft + 1]){
//                childLeft++;
//            }
//            if(temp > A[childLeft]){
//                break;
//
//            }
//            else {
//                A[index] = A[childLeft];
//
//            }
//        }
//        A[index] = temp;
//
//    }
//
//    static void  swap(int[] A, int m, int n){
//        int temp = A[m];
//        A[m] = A[n];
//        A[n] = temp;
//    }

    public static int[] heapSort(int[] A, int n) {
        // write code here
        for (int i = n / 2; i >= 0; i--) {
            heapAdjust(A, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(A, i, 0);
            heapAdjust(A, 0, i);
        }
        return A;
    }

    public static void heapAdjust(int[] A, int index, int length) {
        int tmp = A[index];
        int childLeft;

        while ((childLeft = index * 2 + 1) < length ) {

            if (childLeft != length - 1 && A[childLeft] < A[childLeft + 1])
                childLeft++;

            if (tmp > A[childLeft])
                break;
            else {
                A[index] = A[childLeft];
                index = childLeft;
            }
        }
        A[index] = tmp;

//        int childLeft;
//        int temp = A[index];
//        for( ; index * 2 + 1 < length; index = childLeft){
//            childLeft = index * 2 + 1;
//
//            if(childLeft != length - 1 && A[childLeft] < A[childLeft + 1]){
//                childLeft++;
//            }
//            if(temp > A[childLeft]){
//                break;
//
//            }
//            else {
//                A[index] = A[childLeft];
//
//            }
//        }
//        A[index] = temp;
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i]  = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {8, 2, 6, 3, 1, 2,1, 7};

        heapSort(A, 8);
        for (int a : A) {
            System.out.println(a);
        }

        String s = "aaaa";
        System.out.println(s.substring(1));
    }
}
