package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/26 19:11
 */

/**
 * @problem
 *
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 * @example
 *输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * @idea
 * 动态规划
 * 算出每个点的 左山脉长度 和 右山脉长度
 * 将当前点的左右山脉相加，两放都大于0的情况下，将结果和res比较。
 * 最终返回res。
 */
class Solution {
    int n ;
    public int longestMountain(int[] A) {
        int max_longest = 0 ;
        n = A.length;
        int[] left = new int[n];
        left[0] = 0;
        for(int i = 1 ; i < n ;i ++){
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        right[0] = 0;
        for(int i = n - 1 ; i > 0 ; i --){
            right[i] = A[i] > A[i + 1] ? right[i + 1] + 1 : 0;
        }
        int res  = 0 ;
        for(int i = 0 ; i < n ; i ++){
            if(left[i] > 0 && right[i] > 0){
                res = Math.max(left[i] + right[i] + 1 , res);
            }
        }
        return  res;
    }

}
