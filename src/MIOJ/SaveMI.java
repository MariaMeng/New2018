package MIOJ;



import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by apple on 12/28/18.
 *
 * ����һ��ֻ����Сд��ĸ���ַ����������� mi ��������Ʒ�Ƶ��ַ���Χ�������У���Ҫ���ǽ��ַ����е� mi ȫ���Ƴ�Ȼ���������֤���������ַ�����û�� "mi"��

 ����
 һ�����ݰ���һ���ַ��������� <= 100000���ַ���������Сд��ĸ��

 ���
 ����������ַ���

 ��������
 huaweimivivo
 chuizimmmiioppo
 samsungmimiapple
 ��������
 �������
 huaweivivo
 chuizimoppo
 samsungapple
 */
public class SaveMI {

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
        if (line == null || line.length() == 0) {
            return null;
        }
        line = line.trim();

        Deque<Character> deque = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'i' && !deque.isEmpty() && deque.peekLast() == 'm') {
                deque.pollLast();
            } else {
                deque.offerLast(line.charAt(i));
            }
        }

        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }

        return stringBuilder.toString();
        // return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextLine()));
    }
}
