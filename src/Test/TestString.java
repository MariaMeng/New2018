package Test;

import java.lang.reflect.Field;

/**
 * Created by apple on 10/26/18.
 */
public class TestString {

    public static void main(String[] args) throws Exception {
        String hello="hello world";
        String xx=new String("hello world");
        String yy="hello world";

        //����ж��ڴ��ַ�Ƿ����
        System.out.println("xx==hello : "+ (xx==hello));
        System.out.println("yy==hello : "+ (yy==hello)+"\n");

        //ͨ�������޸�hello��valueֵ
        Field hello_field=String.class.getDeclaredField("value");
        hello_field.setAccessible(true);
        char[] value=(char[])hello_field.get(hello);
        value[5]='_';

        //��������޸Ľ��
        System.out.println("Hello: "+hello+"\n");

        //Ȼ���ж��ڴ��ַ�Ƿ��б仯
        System.out.println("xx==hello : "+ (xx==hello));
        System.out.println("yy==hello:"+(hello==yy));
        System.out.println("xx==yy:"+(xx==yy)+"\n");

        //����������ֵ�Ľ��
        System.out.println("xx: "+xx);
        System.out.println("yy: "+yy);
        System.out.println("Hello: "+hello);


        testReflection();

        String j1 = new String("kvi");
        String j2 = new String("ll");

        String s1 = j1 + j2;
//        String s3 = "kvill";
        System.out.println(s1 == s1.intern());
        String s3 = "kvill";
        System.out.println(s1 == s3);


        System.out.println("***************");

        String a1 = "a";
        String all = new String("ab");
        String a2 = "b";
        String s = a1 + a2;
        System.out.println(s == s.intern()); //false
        System.out.println(s == all); // false
        System.out.println(s.intern() == all.intern()); // true
        System.out.println(all.intern() == all); // false
    }

    public static void testReflection() throws Exception {

        //�����ַ���"Hello World"�� ����������s
        String s = "Hello World";

        System.out.println();
        System.out.println("s = " + s);	//Hello World

        //��ȡString���е�value�ֶ�
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //�ı�value���Եķ���Ȩ��
        valueFieldOfString.setAccessible(true);

        //��ȡs�����ϵ�value���Ե�ֵ
        char[] value = (char[]) valueFieldOfString.get(s);

        //�ı�value�����õ������еĵ�5���ַ�
        value[5] = '_';

        System.out.println("s = " + s);  //Hello_World

        System.out.println(s);
    }




}
