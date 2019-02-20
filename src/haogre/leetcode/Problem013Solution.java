package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haogre
 * @description Problem013 Roman to Integer
 * @date 2016年11月3日
 */
public class Problem013Solution {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// Input is guaranteed to be within the range from 1 to 3999
		// I II III IV V ==== 1 2 3 4 5
		// DCCCXC == 910 FROM CHEETSHEET
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i))==null){
				System.out.println("参数异常"); 
				return 0;
			}
			if (i+1<s.length()&&map.get(s.charAt(i))<map.get(s.charAt(i+1))) {
				result -= map.get(s.charAt(i));
			}else{
				result += map.get(s.charAt(i));
			}
		}

		return result;
	}


	public static void main(String[] args) {
		String x = "MCMXCVI";  //2216 wrong  1996 right  1000+(1000-100)+(100-10)+5+1 = 1996
		//+= 是错误的  后卫比前卫大的时候应该减  比如 IV = 4 
		System.out.println(x.charAt(0)); //==I
		
		Problem013Solution s013 = new Problem013Solution();
		System.out.println(s013.romanToInt(x));
	}
}
