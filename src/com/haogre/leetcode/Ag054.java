package com.haogre.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghao167@meituan.com
 * @date 2021年03月16日 20:42:00
 * @Description https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Ag054 {

    /**
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> rs = new ArrayList<>();

        int upIndex = 0;
        int downIndex = m - 1;
        int leftIndex = 0;
        int rightIndex = n - 1;

        while (upIndex <= downIndex && leftIndex <= rightIndex) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                rs.add(matrix[upIndex][i]);
            }
            upIndex++;
            for (int i = upIndex; i <= downIndex; i++) {
                rs.add(matrix[i][rightIndex]);
            }
            rightIndex--;
            for (int i = rightIndex; i >= leftIndex && upIndex <= downIndex; i--) {
                rs.add(matrix[downIndex][i]);
            }
            downIndex--;
            for (int i = downIndex; i >= upIndex && leftIndex <= rightIndex; i--) {
                rs.add(matrix[i][leftIndex]);
            }
            leftIndex++;
        }
        return rs;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
    public List<Integer> spiralOrder3(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

}
