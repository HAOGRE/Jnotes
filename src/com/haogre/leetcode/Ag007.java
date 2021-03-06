package com.haogre.leetcode;

/**
 * Created by haogre on 12/6/2016.
 */
public class Ag007 {
    public static void main(String[] args) {
        Ag007 s7 = new Ag007();
        int x = 1534236469;
        System.out.println(x / 10 / 10);
        System.out.println(s7.reverse(x));
    }

    public int reverse(int x) {
        if (x == 0) return x;
        int reversed = 0;
        while (x != 0) {
            int temp = reversed * 10 + x % 10;
            x = x / 10;
            if (temp / 10 != reversed) {
                reversed = 0;
                break;
            }
            reversed = temp;
        }
        return reversed;
    }
}
