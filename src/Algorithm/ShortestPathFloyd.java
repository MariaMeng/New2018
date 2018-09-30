package Algorithm;

/**
 * Created by apple on 9/19/18.
 */
public class ShortestPathFloyd {
    /** �ڽӾ��� */
    private int[][] matrix;
    /** ��ʾ������ */
    private int MAX_WEIGHT = Integer.MAX_VALUE;
    /**·������*/
    private int[][] pathMatirx;
    /**ǰ����*/
    private int[][] preTable;

    /**
     * ����ͼ2
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
        //·������D������ʾ���㵽��������·��Ȩֵ֮�͵ľ��󣬳�ʼʱ������ͼ���ڽӾ���
        pathMatirx = new int[matrix.length][matrix.length];
        //ǰ����P����P[m][n] ��ֵΪ m��n�����·����ǰ�����㣬�����ֱ����ֵΪn��Ҳ���ǳ�ʼֵ
        preTable = new int[matrix.length][matrix.length];

        //��ʼ��D,P
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pathMatirx[i][j] = matrix[i][j];
                preTable[i][j] = j;
            }
        }

        //ѭ�� �м侭������
        for (int k = 0; k < matrix.length; k++) {
            //ѭ������·��
            for (int m = 0; m < matrix.length; m++) {

                for (int n = 0; n < matrix.length; n++) {

                    int mn = pathMatirx[m][n];
                    int mk = pathMatirx[m][k];
                    int kn = pathMatirx[k][n];
                    int addedPath = (mk == MAX_WEIGHT || kn == MAX_WEIGHT)? MAX_WEIGHT : mk + kn;


                    if (mn > addedPath) {
                        //�������k����·����ԭ����·�����̣��������Ȩֵ��Ϊ��С��һ��
                        pathMatirx[m][n] = addedPath;
                        //ǰ������Ϊ�����±�Ϊk�Ķ���
                        preTable[m][n] = preTable[m][k];
                    }

                }
            }
        }
    }

    /**
     * ��ӡ �������·��
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
