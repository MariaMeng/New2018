package ObjectOriented.Adaptor;

/**
 * Created by apple on 12/2/18.
 */
public class Test {
    public static void main(String[] args) {
        Client c = new Client();
        Adaptee a = new Adaptee();

        Target t = new Adaptor();
        c.test1(t);

        Target t2 = new Adaptor2(a);
        c.test1(t2);

    }
}
