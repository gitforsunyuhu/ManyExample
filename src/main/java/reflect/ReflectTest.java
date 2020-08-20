package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        try {

            // 通过三种方式可以获取到类类型
            Class reflectClass = Class.forName("reflect.ReflectBean");
            Class reflectClass1 = new ReflectBean().getClass();
            Class reflectClass2 = ReflectBean.class;

            // 通过类类型来创建对象
            ReflectBean reflectBean = (ReflectBean) reflectClass.getConstructor().newInstance();

            // 通过类类型来修改对象的参数
            Field id = reflectClass.getDeclaredField("id");
            id.setAccessible(true);
            id.set(reflectBean, 10);
            System.out.println("field id = " + reflectBean.getId());

            // 获取这个名字叫做setName，参数类型是String的方法
            Method m = reflectBean.getClass().getMethod("setName", String.class);
            // 对h对象，调用这个方法
            m.invoke(reflectBean, "盖伦");
            // 使用传统的方式，调用getName方法
            System.out.println(reflectBean.getName());


        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
