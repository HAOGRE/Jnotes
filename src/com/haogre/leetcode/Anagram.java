package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 3/5/20 3:24 PM
 * @Version : V1.0
 **/
public class Anagram {


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "asfdafadfasdf";
        String t = "asfdafadfasdf";
        System.out.println(isAnagram(s,t));

    }
}
