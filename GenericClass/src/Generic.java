/**
 * Created by zhangang on 11/3/19.
 * https://www.cnblogs.com/coprince/p/8603492.html
 */
public class Generic<B> {
    private B key;

    public Generic(B key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public B getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        System.out.println(genericInteger.getKey());
    }
}
