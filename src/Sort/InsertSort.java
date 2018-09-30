package Sort;

/**
 * Created by apple on 9/29/18.
 */
public class InsertSort {
    public static int[] insertionSort(int[] A, int n) {
        // write code here
        for (int i = 1; i <= n - 1; i++) {
            int tmp = A[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (A[j] <= tmp)  {
                    break;
                }
                A[j + 1] = A[j];
            }
            A[j + 1] = tmp;
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};

        insertionSort(A, 13);

        for (int a:A) {
            System.out.println(a);
        }
    }

}
