package ObjectOriented.Extends;

/**
 * Created by apple on 10/18/18.
 */
public class CatHabbit implements Habbit {
    public void eat() {
        System.out.println("Cat can eat!");
    }
    public void cry() {
        System.out.println("Cat can cry!");
    }
    public void shout() {
        System.out.println("Cat cannot shout!");
    }

    /**
     * 如果是多态的话，父类引用指向子类对象时，父类中没有的方法无法被调用。
     */
    public void laugh() {
        System.out.println("Cat can laugh!");
    }
    public void laugh(int a, int b) {
        System.out.println("Cat can laugh!" + a + b);
    }
    public int laugh(int a) {
        System.out.println("Cat can laugh!" + a);
        return 0;
    }


    public static void main(String[] args) {
        Habbit h = new CatHabbit();
        h.shout();
        CatHabbit hh = (CatHabbit)h;
        hh.laugh();

        CatHabbit ch = new CatHabbit();
        ch.laugh();

        Animal cat = new Cat(20, Color.Yellow, true);
        System.out.println(cat.friends);
        Cat c = (Cat)cat;
        System.out.println(c.friends);
    }

}
