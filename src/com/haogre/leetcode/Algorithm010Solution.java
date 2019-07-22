package com.haogre.leetcode;

/**
 * @author GongJunhao
 * @description
 * @date 2017年11月24日
 */
public class Algorithm010Solution {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));  //false
        System.out.println(isMatch("aa", "aa"));  //true
        System.out.println(isMatch("aaa", "aa"));  //false
        System.out.println(isMatch("aa", "a*"));  //true
        System.out.println(isMatch("aa", ".*"));  //true
        System.out.println(isMatch("ab", ".*"));  //true
        System.out.println(isMatch("aab", "c*a*b"));  //true
    }

    /**
     * java 正则匹配
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        return s.matches(p);
    }

}
