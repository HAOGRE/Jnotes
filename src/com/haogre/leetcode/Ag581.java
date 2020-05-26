package com.haogre.leetcode;

import java.util.Arrays;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-26 15:52
 * @Version : V1.0
 */
public class Ag581 {
    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 你找到的子数组应是最短的，请输出它的长度。
     * <p>
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     */
    /**
     * 暴力两次循环
     * @param nums * @return */
    public int findUnsortedSubarray(int[] nums) {

        // 头 headIndex    headIndex >= headIndex + 1
        // 尾 tailIndex      tailIndex <= tailIndex - 1
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

}
