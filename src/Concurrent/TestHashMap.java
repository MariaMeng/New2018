package Concurrent;

import java.util.HashMap;

/**
 * Created by apple on 10/10/18.
 */


public class TestHashMap {

    private static HashMap< Integer, Integer > map = new HashMap<>(2);
    static class MyThread2 implements Runnable {
        private int i;

        public void setName(int i) {
            this.i = i;
        }

        public void run() {

            map.put(i, i);
        }
    }

    public static void main(String[] args) throws Exception{
        //线程1

        for (int i = 1; i <= 100000; i++) {
            int result = i;
            MyThread2 runnable = new MyThread2();
            runnable.setName(result);
            Thread t = new Thread(runnable);
            t.start();
        }

        //让主线程睡眠5秒，保证线程1和线程2执行完毕
        Thread.sleep(5000);
        for (int i= 1; i <= 100000; i++) {
            //检测数据是否发生丢失
            Integer value = map.get(i);
            if (value==null) {
                System.out.println(i + "数据丢失");
            }
        }

        System.out.println("end...");

    }

}
