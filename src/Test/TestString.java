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

        //输出判断内存地址是否相等
        System.out.println("xx==hello : "+ (xx==hello));
        System.out.println("yy==hello : "+ (yy==hello)+"\n");

        //通过反射修改hello的value值
        Field hello_field=String.class.getDeclaredField("value");
        hello_field.setAccessible(true);
        char[] value=(char[])hello_field.get(hello);
        value[5]='_';

        //首先输出修改结果
        System.out.println("Hello: "+hello+"\n");

        //然后判断内存地址是否有变化
        System.out.println("xx==hello : "+ (xx==hello));
        System.out.println("yy==hello:"+(hello==yy));
        System.out.println("xx==yy:"+(xx==yy)+"\n");

        //最后输出所有值的结果
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

        //创建字符串"Hello World"， 并赋给引用s
        String s = "Hello World";

        System.out.println();
        System.out.println("s = " + s);	//Hello World

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        //改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + s);  //Hello_World

        System.out.println(s);
    }




}
