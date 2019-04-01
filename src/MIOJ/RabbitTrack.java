package MIOJ;

import java.util.Scanner;

/**
 * Created by apple on 3/20/19.
 * ����
 �� N?M ��һ������С���ý���ܿ��ģ��Ӿ������Ͻǵĵ�һ��λ�ÿ�ʼ˳ʱ����������ߣ��ܿ���߱������е�λ�ã�
 ����С������֪���Լ��߹��Ĺ켣�����ܸ���С�������߹��Ĺ켣��

 �����һ���ַ�������С�����߹���λ�õ�ֵ��ɣ��ÿո�ָ�����

 ����
 �������롣

 �� 1 ���� 2 ���������ֱ���� NN �� MM ��ֵ��
 �� 2 ~ NN + 1 �У���ʾ N \cdot MN?M �ľ����е�ÿһ�С�
 ���
 ���Ϊһ���ַ�������С�����߹���λ�õ�ֵ��ɣ��ÿո�ָ���

 ��������
 3 3
 1 2 3
 4 5 6
 7 8 9
 ��������
 �������
 1 2 3 6 9 8 7 4 5
 */
public class RabbitTrack {

    static StringBuilder solution = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int start = 0;
        while (start * 2 < m && start * 2 < n) {
            print(matrix, m, n, start);
            start++;
        }

        System.out.println(solution);
    }

    public static void print(int[][] matrix, int m, int n, int start) {
        int endCol = n - 1 - start;
        int endRow = m - 1 - start;

        for (int i = start; i <= endCol; i++) {
            solution.append(matrix[start][i] + " ");
        }

        if (endRow > start) {
            for (int i = start + 1; i <= endRow; i++) {
                solution.append(matrix[i][endCol] + " ");
            }
        }

        if (endCol > start && endRow > start) {
            for (int i = endCol - 1; i >= start; i--) {
                solution.append(matrix[endRow][i] + " ");
            }
        }

        if (endCol > start && endRow - 1 > start) {
            for (int i = endRow - 1; i > start; i--) {
                solution.append(matrix[i][start] + " ");
            }
        }
    }



}
