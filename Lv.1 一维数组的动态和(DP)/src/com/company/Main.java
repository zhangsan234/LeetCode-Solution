package com.company;

/*   题目
    给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
    请返回 nums 的动态和。

    示例：
    输入：nums = [1,2,3,4]
    输出：[1,3,6,10]
    解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。

 */
    class Solution {
        public int[] runningSum(int[] nums) {
            if(nums == null || nums.length == 0 )return null;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i = 1; i <= nums.length-1 ; i++){
                dp[i] = dp[i-1] + nums[i];
            }
            return dp;
        }
    }

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{3,1,2,10,1};
        Solution solution = new Solution();
        for(int a : solution.runningSum(nums)){
            System.out.println(a);
        }
    }
}
