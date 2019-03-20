package ObjectOriented.Adaptor;

/**
 * Created by apple on 12/2/18.
 * 适配器，使用组合的方式跟被适配对象整合
 */
public class Adaptor2 implements Target{

    private Adaptee adaptee;

    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adaptor2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
