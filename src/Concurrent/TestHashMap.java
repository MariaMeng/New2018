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
        //�߳�1

        for (int i = 1; i <= 100000; i++) {
            int result = i;
            MyThread2 runnable = new MyThread2();
            runnable.setName(result);
            Thread t = new Thread(runnable);
            t.start();
        }

        //�����߳�˯��5�룬��֤�߳�1���߳�2ִ�����
        Thread.sleep(5000);
        for (int i= 1; i <= 100000; i++) {
            //��������Ƿ�����ʧ
            Integer value = map.get(i);
            if (value==null) {
                System.out.println(i + "���ݶ�ʧ");
            }
        }

        System.out.println("end...");

    }

}
