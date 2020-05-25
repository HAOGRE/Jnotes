package com.haogre.leetcode;

import java.util.Stack;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-25 16:36
 * @Version : V1.0
 */
public class Ag020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
    /**
     * Stack 数据结构
     * 1. 基本操作
     * InitStack(&S)--------------构造一个空栈
     *
     * IsEmpty:判断栈是否为空
     *
     * ClearStack：清空栈
     *
     * StackLength：栈S的元素个数，即栈的长度
     *
     * GetTop：获取栈顶元素
     *
     * Push：插入新的元素
     *
     * Pop：删除栈顶元素
     */
}
