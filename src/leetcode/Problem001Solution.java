package leetcode;

/**
 * @author haogre
 * @description
 * @date 2016年10月25日
 */
public class Problem001Solution {

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i!=j&&nums[i] + nums[j] == target) {//i!=j forget this partten  
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3,2,4};
		int target = 6;

		Problem001Solution problem001Solution = new Problem001Solution();
		int[] twoSum = problem001Solution.twoSum(arr, target);

		System.out.println("the first index is " + "-" + twoSum[0] + "-");
		System.out.println("the second index is " + "-" + twoSum[1] + "-");
	}

}
