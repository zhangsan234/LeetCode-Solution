package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/8 8:44
 */

/**
 * @problem
 *  给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @example
 *  输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @idea
 * 递归回溯+剪枝
 * 对于题目中的n个节点,每个节点都有两种状态
 *  1.选取状态:将该节点添加入temp集合中,向下递归,递归完成后进行回溯,将添加进temp集合中的元素删除
 *  2.不选取状态:直接递归下个节点
 * 递归枚举出所有所有可能的状态,
 * 对于合法的状态 temp集合中的元素数量 和 k 相等 ,当前的temp集合添加进ans集合中
 * 对于不合法的状态 (n中剩余状态没有确定的点的数量 + temp集合当前元素数量) < k(n中剩余的节点全部选取,也不能凑齐 k 个)
 * 最终将结果集ans返回
 *
 *
 *
 */

class Solution {
    LinkedList<Integer> temp = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        back(n,k,1);
        return ans;
    }

    private void back(int n, int k, int index) {
        //所剩余的元素不够填满temp 不合法!
        if(temp.size() + (n - index + 1) < k){
            return ;
        }
        //合法
        if(temp.size() == k){
            ans.add(new LinkedList<>(temp));
            return ;
        }
        //选取当前节点
        temp.add(index);
        //回溯
        back(n , k , index + 1);
        temp.remove(temp.size() - 1);

        //不选取当前节点
        back(n , k , index + 1);
    }
}
