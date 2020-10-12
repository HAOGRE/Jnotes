package com.haogre.leetcode;

import com.haogre.leetcode.extra.TreeNode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * @Author : haogre@gmail.com
 * @Date : 2020-10-12 09:46
 * @Version : V1.0
 */
public class Ag530 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     * <p>
     * <p>
     * 方法一：中序遍历
     * 思路与算法
     * <p>
     * 考虑对升序数组 aa 求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值，即
     * <p>
     * \textit{ans}=\min_{i=0}^{n-2}\left\{a[i+1]-a[i]\right\}
     * ans=
     * i=0
     * min
     * n−2
     * ​
     * {a[i+1]−a[i]}
     * <p>
     * 其中 nn 为数组 aa 的长度。其他任意间隔距离大于等于 22 的下标对 (i,j)(i,j) 的元素之差一定大于下标对 (i,i+1)(i,i+1) 的元素之差，故不需要再被考虑。
     * <p>
     * 回到本题，本题要求二叉搜索树任意两节点差的绝对值的最小值，而我们知道二叉搜索树有个性质为二叉搜索树中序遍历得到的值序列是递增有序的，因此我们只要得到中序遍历后的值序列即能用上文提及的方法来解决。
     * <p>
     * 朴素的方法是经过一次中序遍历将值保存在一个数组中再进行遍历求解，我们也可以在中序遍历的过程中用 \textit{pre}pre 变量保存前驱节点的值，这样即能边遍历边更新答案，不再需要显式创建数组来保存，需要注意的是 \textit{pre}pre 的初始值需要设置成任意负数标记开头，下文代码中设置为 -1−1。
     * <p>
     * 二叉树的中序遍历有多种方式，包括递归、栈、Morris 遍历等，读者可选择自己最擅长的来实现。下文代码提供最普遍的递归方法来实现，其他遍历方法的介绍可以详细看「94. 二叉树的中序遍历」的题解，这里不再赘述
     */
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
