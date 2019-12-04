package proxy;

/**
 * Created by zhangang on 12/4/19.
 */

public class Test {

    public static void main(String[] args) {
        ProxySaler proxySaler = new ProxySaler();
        Person object = (Person) proxySaler.newInstall(new xiaoQiang("黄豪强", "南山区"));
        object.buy1();
        //object.buy();
    }
}
