package com.company;

import java.util.Scanner;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0,high = numbers.length - 1;
        while(low<high){
            int sum = numbers[low] + numbers[high];
            if(target == sum){
                return new int[]{low+1,high+1};
            }else if(target < sum){
                --high;
            }else {
                ++low;
            }
        }
        return new int[]{-1,1};
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println("请输入目标主数:");
        int i = Integer.parseInt(new Scanner(System.in).nextLine());
        Solution solution = new Solution();
        for(int num : solution.twoSum(nums,i)){
            System.out.println(num);
        }

    }
}
