package ObjectOriented.Decorator;

/**
 * Created by apple on 12/2/18.
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        System.out.println("�����µĹ���, ����-----");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("�����¹��ܣ�ˮ����-----");
        WaterCar waterCar = new WaterCar(car);
        waterCar.move();

        System.out.println("���������µĹ��ܣ����У�ˮ����---------");
        WaterCar waterCar1 = new WaterCar(new FlyCar(car));
        waterCar1.move();
    }


}
