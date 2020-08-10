package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/8/10 10:27
 *
 * @problem
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * @example
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * @idea
 * 数学归纳法
 *
 * 用list装连续相同数字出现的个数，相邻两个数字之间的最小值就是这两个段之间的非空连续子字符串的数量
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> amount = new ArrayList<Integer>();
        int i = 0 ;
        while(i < s.length()){
            char c = s.charAt(i);
            int count = 0;
            while(i <s.length() && s.charAt(i) == c){
                count++;
                i++;
            }
            amount.add(count);
        }
        int res = 0 ;
        for(int j = 1 ; j < amount.size() ; ++j){
            res += Math.min(amount.get(j),amount.get(j-1));
        }
       return res;
    }
}
