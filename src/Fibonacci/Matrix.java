package Fibonacci;

import java.util.Scanner;

import static java.lang.Math.log10;
import static java.lang.Math.sqrt;

/**
 * Created by apple on 10/17/18.
 */
public class Matrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n <= 39) {
            long[][] mat = fb(n);
            String str = String.format("%04d", mat[0][1]);
            System.out.println(str);
        } else {

            long[][] ans = pow_mat( a , n-2);
            ans = matrixMultiply(ans, b);
            String str = String.format("%04d", ans[0][0]);
            System.out.println(str);
        }


    }

    private static int MOD = 10000;


    // 关联矩阵
    private static final long[][] UNIT = { { 1, 1 }, { 1, 0 } };
    // 全0矩阵
    private static final long[][] ZERO = { { 0, 0 }, { 0, 0 } };

    private static final long[][] unit = { { 1, 0 }, { 0, 1 } };
    private static final long[][] a = UNIT;
    private static final long[][] b = { { 1, 0 }, { 1, 0 } };

    public static long mod (long x) {
        return x % MOD;
    }

    static long[][] pow_mat(long[][] a, int x){
        long[][] ret = unit;
        while(x != 0){
            if((x & 1) != 0)
                ret = matrixMultiply(ret, a);
            a = matrixMultiply(a, a);
            x >>= 1;
        }
        return ret;
    }


    /**
     * 求斐波那契数列
     *
     * @param n
     * @return
     */
    public static long[][] fb(int n) {
        if (n == 0) {
            return ZERO;
        }
        if (n == 1) {
            return UNIT;
        }
        // n是偶数
        if ((n & 1) == 0) {
            long[][] matrix = fb(n >> 1);
            return matrixMultiply(matrix, matrix);
        }
        // n是奇数
        long[][] matrix = fb((n - 1) >> 1);
        return matrixMultiply(matrixMultiply(matrix, matrix), UNIT);
    }


    /**
     * 矩阵相乘
     *
     * @param m
     *            r1*c1
     * @param n
     *            c1*c2
     * @return 新矩阵,r1*c2
     */
    public static long[][] matrixMultiply(long[][] m, long[][] n) {
        int rows = m.length;
        int cols = n[0].length;
        long[][] r = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                r[i][j] = 0;
                for (int k = 0; k < m[i].length; k++) {
                    r[i][j] += mod(m[i][k] * n[k][j]);
                }
                r[i][j] = mod(r[i][j]);
            }
        }
        return r;
    }

}
