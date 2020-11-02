package com.company;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Zhangsan
 * @date 2020/11/2 23:00
 */

/**
 * @problem
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @example
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * @idea
 * 两个哈希表
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int i : nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        return set2.stream().mapToInt(i -> i).toArray();
    }
}
