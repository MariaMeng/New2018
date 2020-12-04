package Date.Mar;

/**
 * @author mengxiang
 * @date 20/4/12
 */
public class Leetcode5383 {
    long sum = 0;
    public int numOfWays(int n) {
        int[][] visited = new int[n][3];
        backtrack(visited, 0, 0, n * 3);
        return (int) (sum % (int)(1e9 + 7));
    }

    public void backtrack(int[][] data, int row, int col, int n) {
        if (row < 0 || col < 0 || row >=data.length || col >= data[0].length) return ;
        if (data[row][col] != 0) {
            return ;
        }
        for (int i = 1; i <= 3; i++) {
            if (row - 1 >= 0 && data[row - 1][col] == i) continue;
            if (col - 1 >= 0 && data[row][col - 1] == i) continue;
            if (row + 1 < data.length && data[row + 1][col] == i) continue;
            if (col + 1 < data.length && data[row][col + 1] == i) continue;

            data[row][col] = i;
            if (n - 1 > 0) {
                backtrack(data, row + 1, col, n - 1);
                backtrack(data, row - 1, col, n - 1);
                backtrack(data, row, col + 1, n - 1);
                backtrack(data, row, col - 1, n - 1);
            } else {
                sum++;
            }
            data[row][col] = 0;
        }
    }
    public static void main(String[] args) {
        Leetcode5383 ll = new Leetcode5383();
        int n = 1;
        ll.numOfWays(n);
        System.out.println(ll.sum);
    }
}
