package com.company;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hash.put(nums[i],i);
        }
        for(int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if(hash.containsKey(complement) && hash.get(complement) != i){
                return new int[]{i,hash.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a = new int[2];
        int[] p = new int[]{2, 7, 11, 15};
        Solution solution = new Solution();
        for(int i : solution.twoSum(p,13)){
            System.out.println(i);
        }
    }
}
