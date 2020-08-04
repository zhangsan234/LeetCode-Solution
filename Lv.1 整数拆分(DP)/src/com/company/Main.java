package com.company;


/*
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

 */

class Solution {
    public int integerBreak(int n) {
        if(n == 0 )return 0 ;
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            int max = 0 ;
            for(int j = 1 ; j < i ; ++j){
                max = Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Solution().integerBreak(10));
    }
}
