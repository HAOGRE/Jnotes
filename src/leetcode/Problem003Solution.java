package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haogre
 * @description
 * @date 2016年10月31日
 */
public class Problem003Solution {

	/**
	 * my Solution
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {

		List<String> resultStr = new ArrayList<>();

		String result = "";
		int length = 0;
		if (!"".equals(s)) {
			for (int j = 0; j < s.length(); j++) {
				for (int i = 0; i < s.length(); i++) {
					if ("".equals(result)) {
						result = result + s.substring(i, i + 1);
					} else {
						if (result.contains(s.substring(i, i + 1))) {
							resultStr.add(result);
							result = "";
						} else {
							result = result + s.substring(i, i + 1);
							if (i == s.length() - 1) {
								resultStr.add(result);
							}
						}
					}
				}
			}
			if (resultStr.size() > 0) {
				for (String string : resultStr) {
					if (string.length() > length) {
						length = string.length();
					}
				}
			} else {
				length = 0;
			}

		} else {
			length = 0;
		}
		return length;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		String s1 = "bbbbb";
		String s2 = "pwwkew";

		Problem003Solution solution = new Problem003Solution();
		System.out.println(solution.lengthOfLongestSubstring(s));
		System.out.println(solution.lengthOfLongestSubstring(s1));
		System.out.println(solution.lengthOfLongestSubstring(s2));
	}
}