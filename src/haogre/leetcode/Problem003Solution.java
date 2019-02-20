package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
     * Offical Solution1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
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
    
    /**
     * Offical Solution2
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    
    /**
     * Offical Solution3
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
    /**
     * Offical Solution4
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
    	int n = s.length(), ans = 0;
    	int[] index = new int[128]; // current index of character
    	// try to extend the range [i, j]
    	for (int j = 0, i = 0; j < n; j++) {
    		i = Math.max(index[s.charAt(j)], i);
    		ans = Math.max(ans, j - i + 1);
    		index[s.charAt(j)] = j + 1;
    	}
    	return ans;
    }
    
    
}