package com.haogre.leetcode;

/**
 * @author haogre
 * @description Algorithm013 Integer to Roman
 * @date 2016年11月3日
 */
public class Algorithm012Solution {
    //Input is guaranteed to be within the range from 1 to 3999. 没有太大意义 抄来一个
    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digit = 0;
        while (num > 0) {
            int times = num / nums[digit];
            num -= nums[digit] * times;
            for (; times > 0; times--) {
                res.append(symbols[digit]);
            }
            digit++;
        }
        return res.toString();
    }
}
