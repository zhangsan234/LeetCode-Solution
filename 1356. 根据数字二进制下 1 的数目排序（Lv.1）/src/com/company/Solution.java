package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Zhangsan
 * @date 2020/11/6 19:03
 */

/**
 * @problem
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * @example
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 *
 * 提示：
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 * @idea
 *  动态规划：
 *  dp[i]为 数字i转化为二进制后，拥有1的个数
 *
 *  状态转移方程式：
 *  dp[i] = dp[i >> 1] + (i & 1);
 *  dp[i] 的值为 数字（i >> 1）二进制下存在1的个数 + i的第一位数是否为1 （可以用i & 1）
 *  最后用collections.sort()和new一个comparator使用dp[i]进行比较
 *  最后返回结果集
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> arrs = new ArrayList<>();
        for(int i : arr){
            arrs.add(i);
        }
        int[] bit = new int[10001];
        bit[0] = 0;
        for(int i = 1 ; i < 10001 ; i++){
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(arrs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(bit[o1] != bit[o2]){
                    return bit[o1] - bit[o2];
                }else {
                    return o1 - o2;
                }
            }
        });
        for(int i = 0 ; i < arrs.size() ; i ++){
            arr[i] = arrs.get(i);
        }
        return arr;
    }
}
