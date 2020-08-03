package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/magic-index-lcci/
 * @Author : haogre@gmail.com
 * @Date : 2020/7/31 10:30
 * @Version : V1.0
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 **/
public class Ag0731 {

    // 暴力解法
    public int findMagicIndex(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            // i++ 找到返回即可 最坏情况O(n) 最后一个适合
            if (i == nums[i]) {
                return i;
            }
        }
        return ans;
    }

    class Solution {
        public int findMagicIndex(int[] nums) {
            return getAnswer(nums, 0, nums.length - 1);
        }

        public int getAnswer(int[] nums, int left, int right) {
            if (left > right) {
                return -1;
            }
            int mid = (right - left) / 2 + left;
            int leftAnswer = getAnswer(nums, left, mid - 1);
            if (leftAnswer != -1) {
                return leftAnswer;
            } else if (nums[mid] == mid) {
                return mid;
            }
            return getAnswer(nums, mid + 1, right);
        }
    }

}
