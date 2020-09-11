package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/11 10:57
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @problem
 *找出所有相加之和为n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * @example
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @idea
 * 二进制 ；
 * 用1 ~ 9 位二进制表示选取情况
 *  0 表示不选
 *  1 表示选取
 *  整体用 << 进行计算
 *
 *  满足条件的temp添加入结果集ans中
 *  每次判断之后，都要情况temp。
 *  最后返回结果集ans
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for(int i = 1 ; i < (1 << 9) ; i++){
            if(DFS(i , k , n)){
                ans.add(temp);
            }
        }
        return ans;
    }

    private boolean DFS(int mask , int k, int n) {
        temp.clear();
        for(int i = 1 ; i < 9 ;i++){
            if((mask & (i << i)) != 0){
                temp.add(i);
            }
        }
        if(temp.size() != k){
            return false;
        }
        int sum = 0;
        for(int i : temp){
            sum += i;
        }
        return sum == n ;

    }
}
