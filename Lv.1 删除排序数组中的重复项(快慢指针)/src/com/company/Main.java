package com.company;
/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int low = 0;
        for(int i = 0 ; i < nums.length ; i ++ ){
            if(nums[low] != nums[i]){
                low++;
                nums[low] = nums[i];
            }
        }
        return low+1;
    }
}



public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
