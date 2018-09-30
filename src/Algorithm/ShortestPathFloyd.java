package Algorithm;

/**
 * Created by apple on 9/19/18.
 */
public class ShortestPathFloyd {
    /** 邻接矩阵 */
    private int[][] matrix;
    /** 表示正无穷 */
    private int MAX_WEIGHT = Integer.MAX_VALUE;
    /**路径矩阵*/
    private int[][] pathMatirx;
    /**前驱表*/
    private int[][] preTable;

    /**
     * 创建图2
     */
    private void createGraph2(int index) {
        matrix = new int[index][index];

        int[] v0 = { 0, MAX_WEIGHT, MAX_WEIGHT, 1};
        int[] v1 = { MAX_WEIGHT, 0, 1, MAX_WEIGHT};
        int[] v2 = { MAX_WEIGHT, 1, 0, 1};
        int[] v3 = { 1, MAX_WEIGHT, 1, 0};

        matrix[0] = v0;
        matrix[1] = v1;
        matrix[2] = v2;
        matrix[3] = v3;


    }

    public void floyd(){
        //路径矩阵（D），表示顶点到顶点的最短路径权值之和的矩阵，初始时，就是图的邻接矩阵。
        pathMatirx = new int[matrix.length][matrix.length];
        //前驱表（P），P[m][n] 的值为 m到n的最短路径的前驱顶点，如果是直连，值为n。也就是初始值
        preTable = new int[matrix.length][matrix.length];

        //初始化D,P
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pathMatirx[i][j] = matrix[i][j];
                preTable[i][j] = j;
            }
        }

        //循环 中间经过顶点
        for (int k = 0; k < matrix.length; k++) {
            //循环所有路径
            for (int m = 0; m < matrix.length; m++) {

                for (int n = 0; n < matrix.length; n++) {

                    int mn = pathMatirx[m][n];
                    int mk = pathMatirx[m][k];
                    int kn = pathMatirx[k][n];
                    int addedPath = (mk == MAX_WEIGHT || kn == MAX_WEIGHT)? MAX_WEIGHT : mk + kn;


                    if (mn > addedPath) {
                        //如果经过k顶点路径比原两点路径更短，将两点间权值设为更小的一个
                        pathMatirx[m][n] = addedPath;
                        //前驱设置为经过下标为k的顶点
                        preTable[m][n] = preTable[m][k];
                    }

                }
            }
        }
    }

    /**
     * 打印 所有最短路径
     */
    public void print() {

        for (int m = 0; m < matrix.length; m++) {
            for (int n = m + 1; n < matrix.length; n++) {

                int k = preTable[m][n];
                System.out.print("(" + m + "," + n + ")" + pathMatirx[m][n] + ":  ");
                System.out.print(m);
                while (k != n) {
                    System.out.print("->" + k);
                    k = preTable[k][n];
                }

                System.out.println("->" + n);
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        ShortestPathFloyd floyd = new ShortestPathFloyd();
        floyd.createGraph2(4);


        floyd.floyd();

        floyd.print();

    }
}
