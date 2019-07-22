package com.haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: SingletonLazySafe
 * @Author : haogre@gmail.com
 * @Date : 2019-07-22 14:57
 * @Version : V1.0
 **/
public class SingletonLazySafe {

    private static SingletonLazySafe instance;

    private SingletonLazySafe() {

    }

    public static synchronized SingletonLazySafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazySafe();
        }
        return instance;
    }
}
