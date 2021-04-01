package com.haogre.leetcode;

import java.util.ArrayList;

/**
 * @author zhanghao167@meituan.com
 * @date 2021年04月01日 21:04:00
 * @Description https://leetcode-cn.com/problems/clumsy-factorial/
 */
public class Ag1006 {
    /**
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     *
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     *
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     *
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     *
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     *
     */
    public int clumsy(int n) {

        // 4个一组 每组之间用 用减号
        ArrayList<Integer> rsList = new ArrayList<>();


        int tmp = 1;
        int index = 0;
        while (n > 0) {
            if (index == 0) {
                tmp = n;
                index++;
                if (n == 1) {
                    rsList.add(tmp);
                }
            }
            if (index == 1) {
                tmp = tmp * n;
                index++;

                if (n == 1) {
                    rsList.add(tmp);
                }
            }
            if (index == 2) {
                tmp = tmp / n;
                index++;

                if (n == 1) {
                    rsList.add(tmp);
                }
            }
            if (index == 3) {
                tmp = tmp + n;
                index = 0;
                rsList.add(tmp);
            }
        }


        int result = rsList.get(0);
        for (int i = 1; i < rsList.size(); i++) {
            result -= rsList.get(i);
        }

        return result;
    }
}
