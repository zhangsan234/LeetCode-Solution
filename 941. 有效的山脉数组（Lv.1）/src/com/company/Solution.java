package com.company;

/**
 * @author Zhangsan
 * @date 2020/11/3 11:44
 */

/**
 * @problem
 * (绝对升序和降序)
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * @example
 *
 * 输入：[2,1]
 * 输出：false
 *
 * @idea
 * 线性遍历：
 *    找到升序片段长度，再找到降序片段长度；
 *    长度相加和数组长度比较，且要求峰值不为开始或结束位置
 *
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int left = 1 , right = 1 ;
        for(int i = 1 ; i < A.length ; i ++){
            if(A[i - 1] < A[i]){
                left ++;
            }else break;
        }
        for(int i = left  ; i < A.length ; i ++){
            if(A[i -1] > A[i] ){
                right ++;
            }else break;
        }
        return left != 1 && right != 1 && right + left - 1 == A.length;
    }
}
