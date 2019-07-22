package com.haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 2019-02-20 17:13
 **/
public class SingletonInnerClass {
    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    private SingletonInnerClass() {
    }

    public static final SingletonInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
