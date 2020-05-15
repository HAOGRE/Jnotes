package com.haogre.leetcode;


import com.haogre.leetcode.extra.TreeNode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/15 15:58
 * @Version : V1.0
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 **/
public class Ag055 {

    public boolean isBalanced(TreeNode root) {
        return calc(root) != -1;
    }

    private int calc(TreeNode root) {
        // null ->> true
        if (root == null) return 0;
        // 算左
        int left = calc(root.left);
        if (left == -1) return -1;
        // 算右
        int right = calc(root.right);
        if (right == -1) return -1;
        // 综合左右
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
