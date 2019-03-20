package ObjectOriented.FactionPattern;

/**
 * Created by apple on 10/18/18.
 */
public class DefaultFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new Apple();
    }
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
