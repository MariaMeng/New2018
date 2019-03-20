package Algorithm;

/**
 * Created by apple on 10/30/18.
 */
public class RemoveElements {
    public static int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int left = 0, right = n - 1;

        while (left < right) {
            while (left < n && A[left] != elem) {
                left++;
            }
            while (right >= 0 && A[right] == elem) {
                right--;
            }
            if (left < right)
                swap(A, left, right);
        }
        return A[left] == elem ? left : left + 1;
    }
    public static void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
    public static void main(String[] args) {
        int[] num = {0,4,4,0,0,2,4,4};
        System.out.println(removeElement(num, 4));

        int[] data = new int[2];
        System.out.println(num.getClass().getName());

        String[] name = new String[2];
        System.out.println(name.getClass().getName());

        String[][] namedata = new String[2][2];
        System.out.println(namedata.getClass().getName());
    }
}
