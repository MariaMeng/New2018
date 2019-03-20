package ObjectOriented.Extends;


import java.util.ArrayList;

/**
 * Created by apple on 10/18/18.
 */
public abstract class Animal {
    private int age;
    private Color color;
    private boolean runnable;
    public ArrayList<String> friends;

    public Animal(int age, Color color, boolean runnable) {
        this.age = age;
        this.color = color;
        this.runnable = runnable;
    }
    public Animal() {}

    public int getAge() {
        return this.age;
    }
    public Color getColor() {
        return this.color;
    }
    public boolean isRunnable() {
        return this.runnable;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void shout() {
        System.out.println("Shouting");
    }
    public abstract void run();
    public static boolean isAnimal() {
        System.out.println("It is Animal");
        return true;
    }



}
