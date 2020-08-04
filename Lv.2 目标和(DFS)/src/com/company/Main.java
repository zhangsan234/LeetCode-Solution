package com.company;


import java.util.Scanner;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return DFS(nums,S,0);
    }

    private int DFS(int[] nums, int s, int i) {
        if(s == 0 && i == nums.length){
            return 1;
        }
        if(i >= nums.length){
            return 0;
        }
        int ret = 0;
        ret += DFS(nums,s-nums[i],i+1);
        ret += DFS(nums,s+nums[i],i+1);
        return ret;
    }


}


public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] num = new int[]{1, 1, 1, 1, 1};
        int S = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.println(S);
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(num,S));
    }
}
