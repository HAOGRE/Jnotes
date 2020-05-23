package com.haogre.leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/palindrome-permutation/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/21 00:12
 * @Version : V1.0
 **/
public class Ag266 {
    // todo https://leetcode-cn.com/problems/palindrome-permutation/

    public boolean canPermutePalindrome(String s) {
        HashMap < Character, Integer > map = new HashMap< >();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key: map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }
}
