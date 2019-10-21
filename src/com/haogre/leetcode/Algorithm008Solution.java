package com.haogre.leetcode;

/**
 * @author haogre
 * @description String to Integer (atoi  //此题并未解出 情况太多考虑不到如何全部取出不符合的情况    ascii to integer
 * @date 2016年11月3日
 */
public class Algorithm008Solution {
    public static void main(String[] args) {
        Algorithm008Solution s008 = new Algorithm008Solution();
        System.out.println(s008.myAtoi("2147483648"));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();//去除前后空格
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        if (str.charAt(index) == '+') {//处理+ - 号问题
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num * sign;
    }
}
