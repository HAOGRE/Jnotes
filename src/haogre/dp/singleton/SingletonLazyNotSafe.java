package haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: SingletonLazyNotSafe
 * @Author : haogre@gmail.com
 * @Date : 2019-07-22 14:52
 * @Version : V1.0
 **/
public class SingletonLazyNotSafe {

    private static SingletonLazyNotSafe instance;

    private SingletonLazyNotSafe() {

    }

    public static SingletonLazyNotSafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazyNotSafe();
        }
        return instance;
    }
}
