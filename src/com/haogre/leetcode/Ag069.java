package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 2020/5/9 14:00
 * @Version : V1.0
 **/
public class Ag069 {
    // 这个是牛逼的官方解法，数学公式记不住
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    // 暴力二分查找 判定int边界
    public int mySqrt2(int x) {

        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l - r) / 2 + l;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
