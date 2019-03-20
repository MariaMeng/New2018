package ObjectOriented.FactionPattern;

/**
 * Created by apple on 10/18/18.
 */
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();
}
