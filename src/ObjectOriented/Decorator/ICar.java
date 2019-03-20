package ObjectOriented.Decorator;

/**
 * Created by apple on 12/2/18.
 */
public interface ICar {
    void move();
}


// 具体构建对象（真实对象）
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("陆地上跑！");
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

// ConcreteDecorator 具体装饰对象
class FlyCar extends SuperCar {
    public FlyCar(ICar iCar) {
        super(iCar);
    }

    public void fly() {
        System.out.println("天上飞！");
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
        System.out.println("水上游！");
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
        System.out.println("自动跑！");
    }

    @Override
    public void move() {
        super.move();

        autoMove();
    }
}