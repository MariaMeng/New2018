package VMware;

import java.util.Scanner;

/**
 * Created by apple on 10/16/18.
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
 */
public class HowLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            int Y = in.nextInt();
            int M = in.nextInt();
            int D = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println(findDays(Y, M, D, A, B));
        }

    }
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
    public static int findDays(int Y, int M, int D, int A, int B) {
        int[] day = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M  == A && D <= B)
            return B - D;
        if (M < A) {
            int res = day[M] - D + B + (M == 2 && isLeapYear(Y) ? 1 : 0);
            for (int i = M + 1; i < A; i++) {
                res += day[i];
                if (i == 2 && isLeapYear(Y))
                    res += 1;
            }
            return res;
        }
        else {
            int res = day[M] - D + B + (M == 2 && isLeapYear(Y) ? 1 : 0);
            for (int i = M + 1; i <= 12; i++) {
                res += day[i];
                if (i == 2 && isLeapYear(Y))
                    res += 1;
            }
            for (int i = 1; i < A; i++) {
                res += day[i];
                if (i == 2 && isLeapYear(Y + 1))
                    res += 1;
            }
            return res;
        }
    }

}
