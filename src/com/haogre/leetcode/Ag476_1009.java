package com.haogre.leetcode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/number-complement/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-22 16:21
 * @Version : V1.0
 */
public class Ag476_1009 {

    public int bitwiseComplement(int N) {
        int x = N;
        int count = 1;
        while (x >>> 1 > 0) {
            count++;
            x = x >>> 1;
        }

        int tmp = 1 << count;
        // 和下面的TODO同理
        int res = N ^ (tmp - 1);
        return res;

    }


    /**
     * TODO 还是没明白这个数学公式
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        /*找到数字所在的区间[2^(i-1), 2^i]
          找到上区间，然后减一，取得是全一
          这样num与max-1异或后就是所需要的结果
          例子：5的补数为2，5^2=7，找到5的区间在[4,8],然后8-1=7，得到7
          所以5的补数2=5^7,同理任何数均可如此处理。
          注意：数字类型转换，浮点型和整型。
        */
        double max = 0;
        // 循环找到上限
        for (int index = 0; num >= max; index++) {
            max = Math.pow(2, index);
        }
        // 上限减一取的此区间2进制为全一的数
        int res = (int) (max - 1);
        // 上面的是取 二进制的 1111
        return num ^ res;
    }

    public static void main(String[] args) {
        System.out.println(5 ^ 7);
    }
}
