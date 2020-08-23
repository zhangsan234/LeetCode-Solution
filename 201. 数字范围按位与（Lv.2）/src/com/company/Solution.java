package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/23 14:31
 */

/**
 * @problem
 *给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * @example
 * 输入: [5,7]
 * 输出: 4
 *
 * 输入: [0,1]
 * 输出: 0
 *
 * @idea
 * 寻找最大的公共前缀
 * 例如：8 9 10转换为二进制
 *  1 0 0 0
 *
 *  1 0 0 1
 *
 *  1 0 1 0
 *
 *  最大的公共前缀是 1 0
 *  三个数的按位与的结果是 8 ;
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //判断向右进位了几次
        int shift = 0 ;
        // m < n 是判断前缀是否相等的
        while(m < n){
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }
}
