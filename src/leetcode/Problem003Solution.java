package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haogre
 * @description
 * @date 2016年10月31日
 */
public class Problem003Solution {

	/**
	 * my Solution 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringMySolution(String s) {
		//套了N此循环通过了测试，就不再贴出来了，直接上官方解题思路
		return 0;
	}
	
    /**
     * 但是实际上，对于这个题目，不需要用hashmap，因为所有的字符ASCII码加起来也就最多255个，可以直接用数组来代替hashmap，效率更高。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOffical(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
    
    /**
     * Offical Solution
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    
    
	public static void main(String[] args) {
		String s = "abcabcbb";
		String s1 = "bbbbb";
		String s2 = "pwwkew";
		String s3 = "c";
		String s4 = "ohomm";
		System.out.println(s4.charAt(2));

		Problem003Solution solution = new Problem003Solution();
//		System.out.println(solution.lengthOfLongestSubstring(s));
//		System.out.println(solution.lengthOfLongestSubstring(s1));
//		System.out.println(solution.lengthOfLongestSubstring(s2));
		System.out.println(solution.lengthOfLongestSubstringOffical(s4));
	}
}