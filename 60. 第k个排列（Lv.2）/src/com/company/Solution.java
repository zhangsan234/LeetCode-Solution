package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/5 9:14
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @problem
 *给出集合[1,2,3,…,n]，其所有元素共有n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 *
 * 说明：
 *
 * 给定 n的范围是 [1, 9]。
 * 给定 k的范围是[1, n!]。
 * 示例:
 * @example
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * @idea
 *  数学法+缩小规模
 *  对于n个长度的数字，
 *  其第 1 排的值 因该为 （k / （n - 1）!） + 1！
 *  其第 2 排的值 因该为 k = (k % (n - 1)!) , (k /(n - 2)!) + 1;
 *  其第 n 排... ...;
 *  最后将这些值排列转化为字符串输出。
 *
 *  注意：k 应当先减去1 在后面的除运算后 再加1 ；
 *  例如 当 n = 4 , k = 3！ 时 , 其值应该为 1432；
 *  如果不减去1 ，会变成 2开头的数字
 *
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] buff = new int[n];
        buff[0] = 1;
        for(int i = 1 ; i < n ; i++){
            buff[i] = buff[i - 1] * i;
        }
        --k;

        StringBuilder s = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid,1);

        for(int i = 1 ; i <= n ; i++){
            int order = k / buff[n - i] + 1;
            //判断当前值应该为多少
            for(int j = 1 ; j <= n ; j++){
                order -= valid[j];
                if(order == 0){
                    s.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= buff[n - i];
        }
        return s.toString();
    }
}