package com.haogre.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/submissions/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/23 23:08
 * @Version : V1.0
 **/
public class Ag1293 {
    class Solution {
        public int shortestPath(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            // 非法参数处理
            if (validateInputParams(k, m, n)) {
                return -1;
            }
            // 特殊场景处理
            if (m == 1 && n == 1) {
                return 0;
            }

            // 对于下一个坐标点选择，每个坐标点如果未被访问过 可以直接访问（0）、或还有剩余消除障碍机会（1）
            // 每个坐标点还要记录 选择“我”作为下一层级搜索 还有多少剩余消除障碍机会，肯定是约多越有可能走到最后（贪心）
            // 例子：k=6, 坐标(0,2)可以为消除(0,1)障碍过来的 visited[0][2] = 5，搜索层级为2
            // 也可能为不消除任何障碍过来的 visited[0][2] = 6，层级为6，此时可用6 更新visited[0][2] = 6并入队
            // 同样的坐标节点出发， 有5次消除障碍机会的 可能到不了目标节点；而有6次障碍消除机会的 更有机会，所以要贪心...
            // 0 1 0 0 0 1 0 0
            // 0 1 0 1 0 1 0 1
            // 0 0 0 1 0 0 1 0

            // 二维标记位置，同时记录剩余消除障碍的次数，剩余次数越多 越有价值（此处贪心，记录局部最优）
            int[][] visited = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = -1;
                }
            }
            // 初始步数为0，m=n=1的特殊场景已处理
            int minSteps = 0;

            // 初始位置标记已访问,值记录剩余消除障碍物次数  越多越好
            // 1. 对于其他路径到达此点且剩余消除障碍物次数小于等于当前值 —— 剪枝
            // 2. 对于其他路径到达此点且剩余消除障碍物次数大于当前值 —— 取代并入队
            visited[0][0] = k;
            Queue<Point> queue = new LinkedList<>();
            Point startPoint = new Point(0, 0, 0);
            queue.offer(startPoint);

            // 定义四个方向移动坐标
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            // BFS搜索-队列遍历
            while (!queue.isEmpty()) {
                minSteps++;
                // BFS搜索-遍历相同层级下所有节点
                // 当前队列长度一定要在循环外部定义，循环内部有插入对列操作
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point current = queue.poll();
                    int x = current.x;
                    int y = current.y;
                    int oneCount = current.oneCount;

                    // 对当前节点四个方向进行识别处理
                    for (int j = 0; j < 4; j++) {
                        int xNew = x + dx[j];
                        int yNew = y + dy[j];
                        // 越界判断
                        if (xNew < 0 || xNew >= m || yNew < 0 || yNew >= n) {
                            continue;
                        }
                        // 搜索到目标节点直接返回结果，按层级就是最短步数
                        if (xNew == m - 1 && yNew == n - 1) {
                            return minSteps;
                        }
                        // 穿越障碍次数已满
                        if (grid[xNew][yNew] == 1 && oneCount >= k) {
                            continue;
                        }
                        int oneCountNew = grid[xNew][yNew] == 1 ? oneCount + 1 : oneCount;
                        // 剪枝 - 节点已被访问过，且当前visited记录的剩余障碍物消除次数 >= 当前搜索节点层级的剩余消除次数
                        if (visited[xNew][yNew] != -1 && visited[xNew][yNew] >= k - oneCountNew) {
                            continue;
                        } else {
                            // 否则，贪心将最优值更新，并将该层级节点入队
                            visited[xNew][yNew] = k - oneCountNew;
                        }
                        queue.offer(new Point(xNew, yNew, oneCountNew));
                    }
                }
            }
            // BFS没搜索到目标，返回-1
            return -1;
        }

        private boolean validateInputParams(int k, int m, int n) {
            return m > 40 || m < 1 || n > 40 || n < 1 || k < 1 || k > m * n;
        }

        class Point {
            int x;
            int y;
            int oneCount;

            public Point(int x, int y, int oneCount) {
                this.x = x;
                this.y = y;
                this.oneCount = oneCount;
            }
        }
    }
}
