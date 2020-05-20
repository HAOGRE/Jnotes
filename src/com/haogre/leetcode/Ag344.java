package com.haogre.leetcode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/reverse-string/ 反转字符串
 * @Author : haogre@gmail.com
 * @Date : 2020-05-20 16:17
 * @Version : V1.0
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 *  
 */
public class Ag344 {

    //  双指针法
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            char tmp = s[i];
            if (i < s.length - i - 1) {
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = tmp;
            }
        }
    }

    // 递归忽略

}
