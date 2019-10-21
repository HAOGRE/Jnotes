package com.haogre.java8.lambda;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description: lambda samples
 * @Author : haogre@gmail.com
 * @Date : 2019-07-26 16:17
 * @Version : V1.0
 **/
public class Samples {

    public static void main(String[] args) {

        // 1.排序
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println(names);
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);


        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);
        names2.sort(Comparator.nullsFirst(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(n -> n.sort(Comparator.naturalOrder()));

//        for (String s : names3) {
//            System.out.println(s.toString());
//        }
//        names3.forEach(s -> System.out.println(s));

        Optional.ofNullable(names3).ifPresent(n3 -> n3.forEach(s -> System.out.println(s)));
    }

}
