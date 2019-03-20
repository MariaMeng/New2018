package ObjectOriented.Extends;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 10/18/18.
 */
public class Cat extends Animal{

    public List<String> friends = new LinkedList<>();
    public Cat (int age, Color col, boolean runnable){
        super(age, col, runnable);
    }

    public void run() {
        System.out.println("Cat is ruuning!");
    }
    public static boolean isAnimal() {
        System.out.println("It is Cat!");
        return true;
    }
}
