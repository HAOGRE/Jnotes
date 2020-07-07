package com.haogre.leetcode;

import com.haogre.leetcode.extra.TreeNode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/path-sum/
 * @Author : haogre@gmail.com
 * @Date : 2020-07-07 10:30
 * @Version : V1.0
 */
public class Ag112 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            // 边界
            if (root.left == null && root.right == null) {
                return sum - root.val == 0;
            }
            // 递归遍历
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }
    }
}
