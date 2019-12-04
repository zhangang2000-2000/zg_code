package proxy;

/**
 * Created by zhangang on 12/4/19.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySaler implements InvocationHandler {

    public Person person;

    public Object newInstall(Person person)
    {
        this.person=person;
        return  Proxy.newProxyInstance(person.getClass().getClassLoader(),person.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前的操作");
        if(method.getName().equals("buy")) {
            person.buy();
        }
        if(method.getName().equals("buy1"))
        {
            person.buy1();
        }
        System.out.println("执行方法后的操作");
        return null;
    }
}
