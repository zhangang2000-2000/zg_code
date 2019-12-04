package proxy;

/**
 * Created by zhangang on 12/4/19.
 * https://www.cnblogs.com/socketqiang/p/11212029.html
 */

public class Test {

    public static void main(String[] args) {
        ProxySaler proxySaler = new ProxySaler();
        Person object = (Person) proxySaler.newInstall(new xiaoQiang("黄豪强", "南山区"));
        object.buy1();
        //object.buy();
    }
}
