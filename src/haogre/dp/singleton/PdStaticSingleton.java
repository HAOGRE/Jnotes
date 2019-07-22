package haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: PdStaticSingleton
 * @Author : haogre@gmail.com
 * @Date : 2019-07-22 11:09
 * @Version : V1.0
 **/
public class PdStaticSingleton {
    //创建 PdStaticSingleton 的一个对象
    private static PdStaticSingleton instance = new PdStaticSingleton();

    //让构造函数为 private，这样该类就不会被实例化
    private PdStaticSingleton(){

    }

    //获取唯一可用的对象
    public static PdStaticSingleton getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
    /**
     * 1、懒汉式，线程不安全
     * 2、懒汉式，线程安全
     * 3、饿汉式
     * 4、双检锁/双重校验锁（DCL，即 double-checked locking）
     * 5、登记式/静态内部类
     * 6、枚举
     * 7、反射攻击
     * 8、框架应用
     */
    /**
     */
}
