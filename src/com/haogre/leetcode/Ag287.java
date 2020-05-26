package com.haogre.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-26 11:19
 * @Version : V1.0
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Ag287 {

    /**
     * 效率太低
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        int ansIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ans.containsKey(nums[i])) {
                ansIndex = i;
                break;
            } else {
                ans.put(nums[i], nums[i]);
            }
        }
        return nums[ansIndex];
    }


    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findDuplicate4(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while (true) {
            // slow 走一步
            slow = nums[slow];
            // fast 走两步
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[7];
        nums[0] = 1;
        nums[1] = 4;
        nums[2] = 6;
        nums[3] = 6;
        nums[4] = 6;
        nums[5] = 2;
        nums[6] = 3;
        int duplicate2 = findDuplicate2(nums);
    }

    public int findDuplicate5(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


}
