package DP;

import java.util.Scanner;

/**
 * Created by apple on 12/19/18.
 *
 * ����һ��רҵ�ٷˣ��������ڼƻ�����һ���ֵ��ϵ����з��ӡ�ÿ��������һ���������ֽ�
 * Ψһ�ܹ���ֹ��ľ��ǰ���ϵͳ�������������������ڵķ�����ͬһ����ʱ������ϵͳ�Ż��Զ�������
 * ���ڸ���һ�������������ʾÿ���ֽ������������һ�������ڲ���������ϵͳʱ����������
 *
 *
 * ����
 �ɶ���(,)�ָ���һ������������ʾ��һ������ÿ�������ڵ��ֽ�����

 ���
 һ������������ʾ��������������

 ��������
 1,2

 �������
 2

 */
public class Robbery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(solution(str));
    }


    /**
     * �����룺
     * java.util.*
     * Ҫʹ������ jar ����ʹ������·�����磺
     * java.util.List<java.util.List<Integer>> list = new java.util.ArrayList<java.util.List<Integer>>(100);
     * @param  line Ϊ���в�������
     * @return �����Ľ��
     */
    private static String solution(String line) {
        // please write your code here
        if (line == null || line.length() == 0) return null;

        String[] str = line.split(",");
        if (str == null || str.length == 0) return null;

        int n = str.length;

        int first = 0;
        int second = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num  = Integer.parseInt(str[i]);
            max = Math.max(first, num + second);

            second = first;
            first = max;
        }

        return max + "";
        // return ans;
    }
}
