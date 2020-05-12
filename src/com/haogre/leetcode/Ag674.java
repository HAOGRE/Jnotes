package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/11 15:53
 * @Version : V1.0
 **/
public class Ag674 {
    public int findLengthOfLCIS(int[] nums) {
        // 边界
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}
