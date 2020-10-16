package com.company;

import java.util.Arrays;

/**
 * @author Zhangsan
 * @date 2020/10/16 10:51
 */

/**
 * @problem
 *  给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * @example
 *      输入：[-4,-1,0,3,10]
 *      输出：[0,1,9,16,100]
 *
 *      输入：[-7,-3,2,3,11]
 *      输出：[4,9,9,49,121]
 *
 * @idea
 *   双指针：
 * 因为数组中的元素可以为负数 ， 负数的平方是正数。
 * 所以我们可以使用双指针，初始时分别使他们指向数组的头和尾，比较头和尾的平方值 ， 较大的放入结果数组res的尾部。
 * 然后将双指针向中移动，直到最后遍历完整个数组。
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        /**
         * 双指针
         */
        int n = A.length;
        int[] res = new int[n];
        for(int i = 0 , j = n - 1 , pos = n - 1 ; i <= j ;){
            if(A[i] * A[i] > A[j] * A[j]){
                res[pos] = A[i] * A[i];
                i ++ ;
            }else {
                res[pos] = A[j] * A[j];
                j -- ;
            }
            pos --;
        }
        return res;


        /**
         * 利用jdk中的排序，用不上A数组已经排序的特点
         */
/*      int[] res = new int[A.length];
        for(int i = 0 ; i < A.length ; i++){
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;*/
    }
}
