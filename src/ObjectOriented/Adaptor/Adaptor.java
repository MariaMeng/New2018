package ObjectOriented.Adaptor;

/**
 * Created by apple on 12/2/18.
 * ÊÊÅäÆ÷
 */
public class Adaptor extends Adaptee implements Target{
    @Override
    public void handleReq() {
        super.request();
    }

}
