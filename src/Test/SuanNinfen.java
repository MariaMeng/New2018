package Test;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * �����Ǹ�ʮ�������֢���ߣ��ٹ�һ��ʱ������Ҫ��ĩ�����ˣ��������븴ϰ������������ȥ��������Y��M��D�գ�A��B�վ��ǿ������ڣ�����֪�����ж����졣

 ����
 ��һ��һ����T����ʾ������������1��T��100��

 ������T�У��������������Y��M��D��A��B����֤Ϊ�Ϸ����ڣ���(M, D)��(A, B)�����϶�����Ϊͬһ�졣��1��Y��10000��

 ���
 ��T�У�ÿ��һ�����������A��B����M��D�յ�ǰ�棬�����Y��M��D�յ�Y+1��A��B�ջ��м��죬�������Y��M��D�յ�Y��A��B�ջ��м��졣������ɲο�������


 ��������
 5
 2016 1 2 1 31
 2016 12 30 1 15
 2017 7 1 9 1
 2018 6 6 5 5
 2019 5 1 4 30
 �������
 29
 16
 62
 333
 365

 Hint
 ��һ�飺��1��2����1��31�գ�31-2=29���죩
 �ڶ��飺��12��30�����ڶ���1��15�գ�31-30+15=16���죩
 */
public class SuanNinfen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int Y = in.nextInt();
            int M = in.nextInt();
            int D = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();

//            int res = findDays(Y, M, D, A, B);
//            System.out.println(res);
        }
    }

//    public static int findDays(int Y, int M, int D, int A, int B) {
//        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30,31, 30, 31};
//        if (M == A && D <= B )
//            return B - D;
//        if (M < A) {
//
//            int sum = 0;
//            sum += days[M] - D + B;
//            for (int i = M + 1; i < A; i++) {
//                if (i == 2 && Y % 4 == 0)
//                    sum += days[i] + 1;
//                else
//                    sum += days[i];
//            }
//
//            return sum;
//        } else {
//
//        }
//    }
}
