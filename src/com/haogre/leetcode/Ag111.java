package com.haogre.leetcode;

import com.haogre.leetcode.extra.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-21 14:31
 * @Version : V1.0
 */
public class Ag111 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    // BFS 解法
    public int minDepthBFS(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            // Null 直接返回深度 0
            return 0;
        } else {
            // 非null 扔队列里
            stack.add(new Pair(root, 1));
        }

        int current_depth = 0;
        while (!stack.isEmpty()) {
            // 移除头部 Retrieves and removes the head (first element) of this list.
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                break;
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return current_depth;
    }


    // DFS 解法
    public int minDepthDFS(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            // Retrieves and removes the last element of this list
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }

    // BFS 框架
    // 计算从起点 start 到终点 target 的最近距离
//    int BFS(Node start, Node target) {
//        Queue<Node> q; // 核心数据结构
//        Set<Node> visited; // 避免走回头路
//
//        q.offer(start); // 将起点加入队列
//        visited.add(start);
//        int step = 0; // 记录扩散的步数
//
//        while (q not empty){
//            int sz = q.size();
//            /* 将当前队列中的所有节点向四周扩散 */
//            for (int i = 0; i < sz; i++) {
//                Node cur = q.poll();
//                /* 划重点：这里判断是否到达终点 */
//                if (cur is target)
//                return step;
//                /* 将 cur 的相邻节点加入队列 */
//                for (Node x : cur.adj())
//                    if (x not in visited){
//                    q.offer(x);
//                    visited.add(x);
//                }
//            }
//            /* 划重点：更新步数在这里 */
//            step++;
//        }
//    }

}
