package com.haogre.dsa;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: Fibonacci sequence
 * @Author : haogre@gmail.com
 * @Date : 10/28/19 2:22 PM
 * @Version : V1.0
 **/
public class Fibonacci {
    public static int testNum(int num) {
        if (num < 0) {
            return -1;
        } else if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            return testNum(num - 1) + testNum(num - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(testNum(i));
        }
    }

}
