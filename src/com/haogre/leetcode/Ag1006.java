package com.haogre.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhanghao167@meituan.com
 * @date 2021年04月01日 21:04:00
 * @Description https://leetcode-cn.com/problems/clumsy-factorial/
 */
public class Ag1006 {
    /**
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * <p>
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * <p>
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * <p>
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     * <p>
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     */
    public int clumsy(int N) {
        // 4个一组 每组之间用 用减号
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        // 用于控制乘、除、加、减
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
