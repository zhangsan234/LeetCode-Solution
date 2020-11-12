package com.company;

/**
 * @author Zhangsan
 * @date 2020/11/12 21:23
 */

/**
 * @problem
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * @example
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * @idea
 * 分治法
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] o = new int[n / 2];
        int[] j = new int[n / 2];
        int index1 = 0 , index2 = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] % 2 == 0){
                o[index1] = A[i];
                index1 ++;
            }else {
                j[index2] = A[i];
                index2 ++;
            }
        }
        index1 = 0;
        index2 = 0;
        for(int i = 0 ; i < A.length ; i = i + 2  , index1 ++ , index2 ++){
            A[i] = o[index1];
            A[i + 1] = j[index2];
        }
        return A;
    }
}