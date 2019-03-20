package Algorithm;
import java.util.*;

/**
 * Created by apple on 10/21/18.
 * ��magicMatrixħ���������⡣
 * �ο����ӣ�https://www.cnblogs.com/xkfz007/archive/2012/11/13/2767407.html
 */
public class MagicMatrix {

    /**
     * n Ϊ����ʱ
     * @param n
     */
    public static int[][] magicMatrix_odd(int n){
        int mat[][] = new int [ n ][ n ] ;
        int i = 0 ,j = n / 2 ;  //��һ�������ڵ�һ���м�λ��

        for(int k = 1 ; k <= n * n; k++ ){
            mat[i][j] = k ;   //��ǰλ��ȡֵ
            if( k % n == 0){
                i = ( i + 1) % n ; // ��һ������λ������һ��
            }else{
                i = ( i - 1 + n) % n ;  //��һ������λ�������Ϸ�
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
            square[row][column] = count; // ��A
            square[row+n][column+n] = count + n*n; // ��B
            square[row][column+n] = count + 2*n*n; // ��C
            square[row+n][column] = count + 3*n*n; // ��D
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
                for(j = 0; j < m; j++) // ������� 1
                    SWAP(x, i, j, n / 2 + i, j);

                for(j = 0; j < m1; j++) // ������� 2
                    SWAP(x, i, n - 1 - j, n / 2 + i, n - 1 - j);
            }
            else { // ������� 3
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
        System.out.println("������ħ����Ľ���n");
        int n =  sc.nextInt() ;

        int[][] res = generateMatrix(n);
        for ( int i = 0 ; i < res.length ; i++ ){  //�����ά����
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
