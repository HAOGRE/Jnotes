package com.haogre.leetcode;

/**
 * @author zhanghao167@meituan.com
 * @date 2021年03月23日 19:38:00
 * @Description https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class Ag191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rs = 0;
        while (n != 0) {
            n &= n - 1;
            rs++;
        }
        return rs;
    }
}
