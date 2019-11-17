package annotatiion;

/**https://www.runoob.com/w3cnote/java-annotation.html**/

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
//注解在反射中的作用
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";

}

class Person{
    @Deprecated
    @MyAnnotation
    public void empty(){
        System.out.println("\n"+"empty");
    }
    @MyAnnotation(value={"boy","girl"})
    public void someOne(String name, int age){
        System.out.println("\n"+name+" is "+age+" years old");
    }
}

/**
 * Created by zhangang on 11/17/19.
 */
public class AnnotationTest {
    public static void main(String[] args) throws  Exception{
        Person person = new Person();
        person.empty();
        person.someOne("zhangang",47);
        Class<Person> p = Person.class;
        Method someBody= p.getMethod("someOne", new Class[]{String.class, int.class});
        someBody.invoke(person,new Object[]{"zhangang ",6});
        iteratorAnnotations(someBody);


        Method empty=p.getMethod("empty",new Class[]{});
        empty.invoke(person,new Object[]{});
        iteratorAnnotations(empty);

    }

    public static void iteratorAnnotations(Method method) {

        // 判断 somebody() 方法是否包含MyAnnotation注解
        if(method.isAnnotationPresent(MyAnnotation.class)){
            // 获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for (String str:values)
                System.out.printf(str+", ");
            System.out.println();
        }

        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }
}
