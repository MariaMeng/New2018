package VMware;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

/**
 * Created by apple on 10/16/18.
 * ��n�����������뽫����ƴ�ӳ�һ�ţ����һ�����Ķ�λ���������磺n=3ʱ��3������13��312��343ƴ�ӳɵ��������Ϊ��34331213��

 ����
 ��һ��Ϊ����������n��n<=10000�����ڶ���n���Կո��������������integer���ͣ�

 ���
 ���һ�б�ʾ��


 ��������
 3
 13 312 343
 �������
 34331213

 Hint
 �����е�6�ֲ�ͬ��ƴ�ӷ����У�ֻ��34331213�����ģ��������ֻ��Ҫ���34331213
 */
public class Pinshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] num = new String[n];
        for (int i = 0; i < n; i++) {
            num[i] = String.valueOf(in.nextInt());
        }

        System.out.println(maxPinshu(num));
    }
    public static String maxPinshu(String[] num) {
        Arrays.sort(num, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String O1 = o1 + o2;
                String O2 = o2 + o1;
                return O2.compareTo(O1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String n : num)
            sb.append(n);
        return sb.toString();
    }

}
