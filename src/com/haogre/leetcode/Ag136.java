package com.haogre.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/single-number/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/14 15:14
 * @Version : V1.0
 **/
public class Ag136 {

    // O(n)复杂度
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> rs = new HashMap<>();
        for (int num : nums) {
            if (rs.containsKey(num)) {
                rs.remove(num);
            }else {
                rs.put(num,num);
            }
        }
        return rs.values().iterator().next();
    }

    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
