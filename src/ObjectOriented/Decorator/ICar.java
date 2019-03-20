package ObjectOriented.Decorator;

/**
 * Created by apple on 12/2/18.
 */
public interface ICar {
    void move();
}


// ���幹��������ʵ����
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("½�����ܣ�");
    }
}


class SuperCar implements ICar {

    protected ICar iCar;

    public SuperCar(ICar iCar) {
        this.iCar = iCar;
    }

    @Override
    public void move() {
        iCar.move();
    }
}

// ConcreteDecorator ����װ�ζ���
class FlyCar extends SuperCar {
    public FlyCar(ICar iCar) {
        super(iCar);
    }

    public void fly() {
        System.out.println("���Ϸɣ�");
    }

    @Override
    public void move() {
        super.move();

        fly();
    }
}

class WaterCar extends SuperCar {
    public WaterCar(ICar iCar) {
        super(iCar);
    }

    public void swim() {
        System.out.println("ˮ���Σ�");
    }

    @Override
    public void move() {
        super.move();

        swim();
    }
}

class AICar extends SuperCar {
    public AICar(ICar iCar) {
        super(iCar);
    }

    public void autoMove() {
        System.out.println("�Զ��ܣ�");
    }

    @Override
    public void move() {
        super.move();

        autoMove();
    }
}