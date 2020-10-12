package com.haogre.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @Author : haogre@gmail.com
 * @Date : 2020-06-01 18:12
 * @Version : V1.0
 */
public class Ag1431 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> rs = new ArrayList<>();
        int diff = Arrays.stream(candies).max().getAsInt() - extraCandies;
        for (int i = 0; i < candies.length; i++) {
            rs.add(diff <= candies[i]);
        }
        return rs;
    }

    public static void main(String[] args) {

        int[] params = new int[5];
        params[0] = 2;
        params[1] = 3;
        params[2] = 5;
        params[3] = 1;
        params[4] = 3;


        List<Boolean> booleans = kidsWithCandies(params, 3);

        System.out.println(booleans);

    }
}
