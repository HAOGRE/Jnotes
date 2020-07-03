package com.haogre.leetcode;

import com.haogre.leetcode.extra.TreeNode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Author : haogre@gmail.com
 * @Date : 2020-07-03 14:33
 * @Version : V1.0
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Ag108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
            return nums == null ? null : buildTree(nums, 0, nums.length - 1);
        }

        private TreeNode buildTree(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int m = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[m]);
            root.left = buildTree(nums, l, m - 1);
            root.right = buildTree(nums, m + 1, r);
            return root;
        }
    }

}
