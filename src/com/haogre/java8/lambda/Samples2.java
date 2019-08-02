package com.haogre.java8.lambda;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: Samples2
 * @Author : haogre@gmail.com
 * @Date : 2019-07-31 13:42
 * @Version : V1.0
 **/
public class Samples2 {

    public Object getUser(Object o) {
        return Optional.ofNullable(o).map(o1 -> o1.toString()).orElse(null);
    }
}
