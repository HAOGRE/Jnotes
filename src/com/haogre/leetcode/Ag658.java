package com.haogre.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/find-k-closest-elements/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/23 23:05
 * @Version : V1.0
 **/
public class Ag658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }
}
