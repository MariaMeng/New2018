package Date.July.July302019;

/**
 * Created by apple on 7/30/19.
 */
public class Leetcode576 {

    public static int findPaths(int m, int n, int N, int i, int j) {

        return find(m, n, N, 0, i, j);
    }

    public static int find(int m, int n, int N, int acc, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 1;
        if (acc >= N) {
            return 0;
        }

        int sum = 0;
        sum += find(m, n, N, acc + 1, i + 1, j);
        sum += find(m, n, N, acc + 1, i - 1, j);
        sum += find(m, n, N, acc + 1, i, j + 1);
        sum += find(m, n, N, acc + 1, i, j - 1);
        return sum;
    }

    public static void main(String[] args) {
        int m = 2, n = 2, N = 2, i = 0, j = 0;

        int res = findPaths(m, n, N, i, j);
        System.out.println(res);
    }
}
