package com.haogre.leetcode;

/**
 * @author haogre
 * @description
 * @date 2016年10月25日
 */
public class Ag001 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        int target = 6;

        Ag001 Algorithm001Solution = new Ag001();
        int[] twoSum = Algorithm001Solution.twoSum(arr, target);

        System.out.println("the first index is " + "-" + twoSum[0] + "-");
        System.out.println("the second index is " + "-" + twoSum[1] + "-");

    }

    public int[] twoSum2021(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /**
     * my Solution
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //summary
    //整体来讲 结果正确，效率明显较低  ！ 代码要先想再码 不然脑袋都成浆糊了 !

    /**
     * official Solution
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOfficial(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
