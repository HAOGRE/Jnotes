package com.haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: SingletonDCL
 * @Author : haogre@gmail.com
 * @Date : 2019-07-22 15:04
 * @Version : V1.0
 **/
public class SingletonDCL {
    private volatile static SingletonDCL singleton;

    private SingletonDCL() {
    }

    public static SingletonDCL getSingleton() {
        if (singleton == null) {
            synchronized (SingletonDCL.class) {
                if (singleton == null) {
                    singleton = new SingletonDCL();
                }
            }
        }
        return singleton;
    }
}
