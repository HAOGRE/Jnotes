package haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: SingletonLazySafe
 * @Author : haogre@gmail.com
 * @Date : 2019-07-22 14:57
 * @Version : V1.0
 **/
public class SingletonHungrySafe {

    private static SingletonHungrySafe instance = new SingletonHungrySafe();

    private SingletonHungrySafe() {

    }

    public static SingletonHungrySafe getInstance() {
        return instance;
    }
}
