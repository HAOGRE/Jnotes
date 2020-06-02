package com.haogre.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-20 14:01
 * @Version : V1.0
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 */
public class Ag1371 {

    private static final String VOWELS = "aeiou";

    /**
     * 状态压缩＋哈希表。类似的题出现好几次了。 如1124。 状态压缩后，哈希表的用处是求最长的连续子串，满足子数组的和为k。 此题k为0， 1124题k为1.
     * <p>
     * 遇到奇偶个数校验，想到XOR
     * 遇到有限的参数（小于20个）表状态， 想到状态压缩 （bitmask）
     * 遇到求最长的连续子串使得和为k（maximum continuous subarray(substring) with sum equal to k）想到 前缀和 加哈希表记录第一次出现某一状态的位置。
     * 以后我再做不出类似的就是不长记性。
     *
     * @param s
     * @return
     */
    public static int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = s.length();
        int state = 0; // (00000)
        int maxSize = 0;
        map.putIfAbsent(0, -1);
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < VOWELS.length(); k++) {
                if (s.charAt(i) == VOWELS.charAt(k)) {
                    state ^= (1 << (VOWELS.length() - k - 1));
                    break;
                }
            }
            if (map.containsKey(state)) {
                maxSize = Math.max(maxSize, i - map.get(state));
            }
            map.putIfAbsent(state, i);
        }
        return maxSize;
    }

    /**
     * 官方解法
     *
     * @param s
     * @return
     */
    public static int findTheLongestSubstring2(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                System.out.println(status);
                status ^= (1 << 0);
                System.out.println(status);
            } else if (ch == 'e') {
                System.out.println(status);
                status ^= (1 << 1);
                System.out.println(status);
            } else if (ch == 'i') {
                System.out.println(status);
                status ^= (1 << 2);
                System.out.println(status);
            } else if (ch == 'o') {
                System.out.println(status);
                status ^= (1 << 3);
                System.out.println(status);
            } else if (ch == 'u') {
                System.out.println(status);
                status ^= (1 << 4);
                System.out.println(status);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String xx = "eleetminicoworoep";

        int theLongestSubstring = findTheLongestSubstring(xx);
        int theLongestSubstring2 = findTheLongestSubstring2(xx);

        System.out.println(theLongestSubstring);


//        System.out.println(111111);

//        System.out.println(1 << 0);
//        System.out.println(1 << 1);
//        System.out.println(1 << 2);
//        System.out.println(1 << 3);
//        System.out.println(1 << 4);

    }
}
