package com.haogre.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/single-number-ii/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/14 15:42
 * @Version : V1.0
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 **/
public class Ag137 {
    public int singleNumber(int[] nums) {
        //  aaa bbb c    异或 ->>   a b c  ->> (3(a b c ) - (aaa bbb c)) = 2c  ->>  2c/2 = c
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;

        for (int num : nums) {
            sumArray += num;
            set.add((long) num);
        }
        for (Long s : set) sumSet += s;
        return (int) ((3 * sumSet - sumArray) / 2);
    }

    // 位运算 by office
    public int singleNumber2(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

}
