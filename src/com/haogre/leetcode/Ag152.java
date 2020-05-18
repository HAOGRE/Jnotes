package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/maximum-product-subarray/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/18 23:27
 * @Version : V1.0
 **/
public class Ag152 {

    // dp

    /**
     * 标签：动态规划
     * 遍历数组时计算当前最大值，不断更新
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)O(n)
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            } //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
    // 奇淫技巧  ->> 先计算从左到右的相乘的最大值，再计算从右到左的最大值；再将两组最大值相比
}
