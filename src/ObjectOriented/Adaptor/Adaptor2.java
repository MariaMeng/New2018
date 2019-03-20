package ObjectOriented.Adaptor;

/**
 * Created by apple on 12/2/18.
 * ��������ʹ����ϵķ�ʽ���������������
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
