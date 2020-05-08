package com.haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: SingletonEnum
 * @Author : haogre@gmail.com
 * @Date : 2019-07-22 15:40
 * @Version : V1.0
 **/
public enum SingletonEnum {

    INSTANCE;

    private final Resource instance;

    SingletonEnum() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }
}
