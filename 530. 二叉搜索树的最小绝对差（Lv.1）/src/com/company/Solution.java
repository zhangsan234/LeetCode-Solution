package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/10/12 10:53
 */


/**
 * @problem
 *给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * @example
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * @idea
 *  先将整个搜索树中序遍历，
 *  然后再通过中序遍历之后的数据寻找最小的差值。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        DFS(root,list);
        int left_int = list.get(0);
        int mindifference = Integer.MAX_VALUE;

        for(int i : list){
            System.out.print(i + "  ");
        }
        System.out.println();


        for(int i = 1 ; i < list.size() ; i++){
            int temp = list.get(i) - left_int;
            if(temp < mindifference){
                mindifference = temp;
            }
            left_int = list.get(i);
        }
        return mindifference;
    }

    private void DFS(TreeNode root, List<Integer> list) {
        if(root.left != null){
            DFS(root.left , list);
        }
        list.add(root.val);
        if(root.right != null){
            DFS(root.right , list);
        }
    }
}
