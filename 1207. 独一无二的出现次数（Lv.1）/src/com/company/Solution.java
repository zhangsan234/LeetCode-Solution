package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhangsan
 * @date 2020/10/28 11:30
 */

/**
 * @problem
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * @example
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * @idea
 * 哈希表
 * 利用哈希表记录各个数字出现的次数，在将哈希表中的value（各个数字出现的次数）放入set中，利用set的去重的特点，取出重复的次数；
 * 最终比较哈希表和哈希set的长度，相等代表没有相同的出现次数，反正则代表不满足；
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i , map.getOrDefault(i ,0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            set.add(entry.getValue());
        }
        return map.size() == set.size();
    }
}
