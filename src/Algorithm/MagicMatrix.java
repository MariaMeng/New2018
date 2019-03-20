package Algorithm;
import java.util.*;

/**
 * Created by apple on 10/21/18.
 * 求magicMatrix魔方矩阵问题。
 * 参考链接：https://www.cnblogs.com/xkfz007/archive/2012/11/13/2767407.html
 */
public class MagicMatrix {

    /**
     * n 为奇数时
     * @param n
     */
    public static int[][] magicMatrix_odd(int n){
        int mat[][] = new int [ n ][ n ] ;
        int i = 0 ,j = n / 2 ;  //第一个数放在第一行中间位置

        for(int k = 1 ; k <= n * n; k++ ){
            mat[i][j] = k ;   //当前位置取值
            if( k % n == 0){
                i = ( i + 1) % n ; // 下一个数的位置在下一行
            }else{
                i = ( i - 1 + n) % n ;  //下一个数的位置在右上方
                j = ( j + 1 ) % n ;
            }
        }
        return mat;
    }

    public static int[][] magicMatrix_4N(int N) {
        int i, j;
        int[][] square = new int[N][N];

        for(j = 0; j < N; j++) {
            for(i = 0; i < N; i++){
                if(j % 4 == i % 4 || (j % 4 + i % 4) == 3)
                    square[i][j] = (N - i) * N - j;
                else
                    square[i][j] = i * N + j + 1;
            }
        }
        return square;
    }

    public static int[][] magicMatrix_4Nplus2(int N) {
        int[][] square = new int[N][N];

        magic_o(square,  N/2);
        exchange(square, N);
        return square;
    }

    public static void magic_o(int[][] square, int n) {
        int count, row, column;
        row = 0;
        column = n / 2;
        for(count = 1; count <= n*n; count++) {
            square[row][column] = count; // 填A
            square[row+n][column+n] = count + n*n; // 填B
            square[row][column+n] = count + 2*n*n; // 填C
            square[row+n][column] = count + 3*n*n; // 填D
            if(count % n == 0)
                row++;
            else {
                row = (row == 0) ? n - 1 : row - 1 ;
                column = (column == n-1) ? 0 : column + 1;
            }
        }
    }
    public static void exchange(int[][] x, int n) {
        int i, j;
        int m = n / 4;
        int m1 = m - 1;
        for(i = 0; i < n/2; i++) {
            if(i != m) {
                for(j = 0; j < m; j++) // 处理规则 1
                    SWAP(x, i, j, n / 2 + i, j);

                for(j = 0; j < m1; j++) // 处理规则 2
                    SWAP(x, i, n - 1 - j, n / 2 + i, n - 1 - j);
            }
            else { // 处理规则 3
                for(j = 1; j <= m; j++)
                    SWAP(x, m, j, n / 2 + m, j);
                for(j = 0; j < m1; j++)
                    SWAP(x, m, n-1-j, n/2+m, n-1-j);
            }
        }
    }
    public static void SWAP(int[][] x, int si, int sj, int di, int dj) {
        int tmp = x[si][sj];
        x[si][sj] = x[di][dj];
        x[di][dj] = tmp;
    }


    public static int[][] generateMatrix(int n) {
        int[][] res;
        if (n % 2 != 0)
            res = magicMatrix_odd(n);
        else if (n % 4 == 0)
            res = magicMatrix_4N(n);
        else
            res = magicMatrix_4Nplus2(n);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in) ;
        System.out.println("请输入魔方阵的阶数n");
        int n =  sc.nextInt() ;

        int[][] res = generateMatrix(n);
        for ( int i = 0 ; i < res.length ; i++ ){  //输出二维数组
            for( int j = 0 ; j < res[i].length ; j++ ){
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 2);
        for (int key : map.keySet()) {
            System.out.println(key);
        }
    }
}
