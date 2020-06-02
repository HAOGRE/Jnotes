package com.haogre.leetcode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @Author : haogre@gmail.com
 * @Date : 2020-06-02 10:17
 * @Version : V1.0
 */
public class Iv064 {
    // 递归终止，断路效应
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
