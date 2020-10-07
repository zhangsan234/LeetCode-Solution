package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/7 12:09
 */

/**
 * @problem
 *给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。0
 * @example
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * @idea
 * 单指针
 * 分为两次遍历
 * 需要一个指针指 cur_n 向当前的元素
 * 第一次遍历：将所有的 0 放到 cur_n 的位置
 * 第二次遍历：将所有的 1 放到 cur_n 的位置
 */
class Solution {
    public void sortColors(int[] nums) {
        int cunt = nums.length;
        int cur_n = 0;
        for(int i = 0 ; i < cunt ; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[cur_n];
                nums[cur_n] = temp;
                cur_n++;
            }
        }
        for(int i = cur_n ; i < cunt ; i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[cur_n];
                nums[cur_n] = temp;
                cur_n++;
            }
        }
    }
}
