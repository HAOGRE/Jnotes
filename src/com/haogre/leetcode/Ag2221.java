package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 2020/5/8 13:59
 * @Version : V1.0
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */
public class Ag2221 {
    // 思维逻辑（暴力）解法，肯定有更优解
    public int maximalSquare(char[][] matrix) {
        int rs = 0;
        // 原始矩阵的长宽 遍历计算
        int length = matrix.length;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return rs;
        }
        int width = matrix[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                // 找为'1'元素 然后向右 向下 找元素是否为'1' 不是'1' 终止
                if (matrix[i][j] == '1') {
                    rs = Math.max(rs, 1);
                    // 已当前节点为起点，重新计算可能的最大正方形边长 小为大
                    int currentMaxSide = Math.min(length - i, width - j);
                    // 按小变为上界遍历
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1 // 向右 向下
                        boolean flag = true;
                        // 非'1' 终止
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            rs = Math.max(rs, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return rs * rs;
    }
}
