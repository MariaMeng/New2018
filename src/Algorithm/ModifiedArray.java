package Algorithm;

/**
 * Created by apple on 11/3/18.
 */
public class ModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        if (length == 0) return null;
        int n = updates.length;
        int[] help = new int[length + 1];
        int[] res = new int[length];

        for (int i = 0; i < n; i++) {
            help[updates[i][0]] += updates[i][2];
            help[updates[i][1] + 1] -= updates[i][2];
        }
        int sum = 0;
        for (int i = i = 0; i < length; i++) {
            sum += help[i];
            res[i] = sum;
        }
        return res;
    }
}
