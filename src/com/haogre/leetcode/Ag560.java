package com.haogre.leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/15 10:24
 * @Version : V1.0
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 **/
public class Ag560 {
    /**
     * 枚举 当前节点往前找
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 方法二：前缀和 + 哈希表优化
     * 思路和算法
     * <p>
     * 我们可以基于方法一利用数据结构进行进一步的优化，我们知道方法一的瓶颈在于对每个 ii，我们需要枚举所有的 jj 来判断是否符合条件，这一步是否可以优化呢？答案是可以的。
     * <p>
     * 我们定义 \textit{pre}[i]pre[i] 为 [0..i][0..i] 里所有数的和，则 \textit{pre}[i]pre[i] 可以由 \textit{pre}[i-1]pre[i−1] 递推而来，即：
     * <p>
     * \textit{pre}[i]=\textit{pre}[i-1]+\textit{nums}[i]
     * pre[i]=pre[i−1]+nums[i]
     * <p>
     * 那么「[j..i][j..i] 这个子数组和为 kk 」这个条件我们可以转化为
     * <p>
     * \textit{pre}[i]-\textit{pre}[j-1]==k
     * pre[i]−pre[j−1]==k
     * <p>
     * 简单移项可得符合条件的下标 jj 需要满足
     * <p>
     * \textit{pre}[j-1] == \textit{pre}[i] - k
     * pre[j−1]==pre[i]−k
     * <p>
     * 所以我们考虑以 ii 结尾的和为 kk 的连续子数组个数时只要统计有多少个前缀和为 \textit{pre}[i]-kpre[i]−k 的 \textit{pre}[j]pre[j] 即可。我们建立哈希表 \textit{mp}mp，以和为键，出现次数为对应的值，记录 \textit{pre}[i]pre[i] 出现的次数，从左往右边更新 \textit{mp}mp 边计算答案，那么以 ii 结尾的答案 \textit{mp}[\textit{pre}[i]-k]mp[pre[i]−k] 即可在 O(1)O(1) 时间内得到。最后的答案即为所有下标结尾的和为 kk 的子数组个数之和。
     * <p>
     * 需要注意的是，从左往右边更新边计算的时候已经保证了\textit{mp}[\textit{pre}[i]-k]mp[pre[i]−k] 里记录的 \textit{pre}[j]pre[j] 的下标范围是 0\leq j\leq i0≤j≤i 。同时，由于\textit{pre}[i]pre[i] 的计算只与前一项的答案有关，因此我们可以不用建立 \textit{pre}pre 数组，直接用 \textit{pre}pre 变量来记录 pre[i-1]pre[i−1] 的答案即可。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        // hash
        // 记录合适的连续字符串数量
        int count = 0;
        // 记录前面数字相加之和
        int pre = 0;
        // map记录前几个数字之和为K出现相同和的次数为V
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 如果前面数字之和加上这个数字正好等于K（存在一个数字加上nums[i]结果为K
            // 说明找到了
            if (map.containsKey(pre - k)) {
                // 累计
                count += map.get(pre - k);
            }
            // 计算新的和放入map
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
