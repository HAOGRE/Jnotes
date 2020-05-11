package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/powx-n/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/11 14:17
 * @Version : V1.0
 **/
public class Ag050 {

    /**
     * 搞笑解法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /**
     * 暴力解法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (int i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }

    /**
     * 分治 二分法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {

        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }


}
