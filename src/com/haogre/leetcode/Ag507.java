package com.haogre.leetcode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/perfect-number/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-22 16:42
 * @Version : V1.0
 * 正因子是啥
 */
public class Ag507 {
    /**
     * 标签：数学
     * 首先由于完美数的定义，需要排除自身，所以数字 11 一定不是完美数
     * 其次我们需要计算 num 除了它自身以外的所有正因子之和 sum，正因子必然是成对出现的，故而我们只需要遍历到 num 的平方根 sqrt 即可
     * 以 3636 为例，它的非自身外正因子有，1、2、3、4、6、9、12、18，其中 11 和 66 单独计算，[2, 18]、[3, 12]、[4, 9]都是对应关系、
     * 所以只需要遍历到 3636 的平方根 66 就可以获取全部正因子
     * 11 单独计算的原因是要排除自身，66 单独计算的原因是 6 * 6 = 36，两个值相同，故而只能计算一遍
     * 时间复杂度：O(\sqrt{n})O(
     * n
     * ​
     * )，nn 为 num 的大小
     * Tips：完美数只有 6, 28, 496, 8128, 33550336 这几个，可以通过判断该数字是否为以下几个来解决
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1; // 正整数一定会有一个1，同时不用考虑自身，所以单独处理
        int i = 2;
        double sqrt = Math.sqrt(num);
        for (; i < sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        // 此处单独处理的原因在于只需要加1次i值，如果在循环中会加2次
        if (i * i == num) {
            sum += i;
        }
        return sum == num;
    }
}
