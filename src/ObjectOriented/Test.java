package ObjectOriented;

import ObjectOriented.FactionPattern.*;
import ObjectOriented.SingleTon.Singleton1;

/**
 * Created by apple on 10/18/18.
 */
public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run(){
                            try {
                                Thread.sleep(1000);
                            }catch (Exception e) {

                            }
                            Singleton1 s1 = Singleton1.getInstance();
                            System.out.print(Thread.currentThread().getId() + ": ");
                            System.out.println(s1.hashCode());
                        }
                    }).start();
                }
            }
        });
        t.start();

        AbstractFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        v.run();
        Weapon w = f.createWeapon();
        w.shoot();
        Food a = f.createFood();
        a.printName();
    }

}
