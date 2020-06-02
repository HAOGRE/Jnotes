package com.haogre.leetcode;

import java.util.*;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-21 10:19
 * @Version : V1.0
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * BFS 常用于找单一的最短路线，它的特点是 "搜到就是最优解"，而 DFS 用于找所有解的问题，它的空间效率高，而且找到的不一定是最优解，必须记录并完成整个搜索，故一般情况下，深搜需要非常高效的剪枝（剪枝的概念请百度）。
 * BFS 的重点在于队列，而 DFS 的重点在于递归。这是它们的本质区别。
 * // todo 晚上刷
 */
public class Ag417 {

    /**
     * 二维矩阵的所在位置的 上下左右 都比该元素小  DFS 递归
     * DFS
     *
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlanticiDFS(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        //从海洋边界开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dfs(matrix, pacific, i, j, matrix[i][j]);
                }
                if (i == m - 1 || j == n - 1) {
                    dfs(matrix, atlantic, i, j, matrix[i][j]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int[][] aux, int i, int j, int pre) {
        //判断边界
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1
                //已经流到过了
                || aux[i][j] == 1
                //不能流动
                || matrix[i][j] < pre) {
            return;
        }

        aux[i][j] = 1;

        dfs(matrix, aux, i - 1, j, matrix[i][j]);
        dfs(matrix, aux, i + 1, j, matrix[i][j]);
        dfs(matrix, aux, i, j - 1, matrix[i][j]);
        dfs(matrix, aux, i, j + 1, matrix[i][j]);
    }


    /**
     * BFS 队列
     *
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlanticBFS(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        int[][] pacificAux = new int[m][n];
        int[][] atlanticAux = new int[m][n];

        //从海洋边界开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacificQueue.add(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    atlanticQueue.add(new int[]{i, j});
                }
            }
        }

        bfs(matrix, pacificAux, pacificQueue);
        bfs(matrix, atlanticAux, atlanticQueue);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificAux[i][j] == 1 && atlanticAux[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] matrix, int[][] aux, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] array = queue.remove();
            int i = array[0];
            int j = array[1];
            //流到的区域就置为1
            aux[i][j] = 1;
            if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j] && aux[i - 1][j] != 1) {
                queue.add(new int[]{i - 1, j});
            }
            if (i + 1 < matrix.length && matrix[i][j] <= matrix[i + 1][j] && aux[i + 1][j] != 1) {
                queue.add(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1] && aux[i][j - 1] != 1) {
                queue.add(new int[]{i, j - 1});
            }
            if (j + 1 < matrix[0].length && matrix[i][j] <= matrix[i][j + 1] && aux[i][j + 1] != 1) {
                queue.add(new int[]{i, j + 1});
            }
        }
    }


}
