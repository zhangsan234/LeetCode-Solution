package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/10/29 10:20
 */


/**
 * @problem
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @example
 *  输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * @idea
 *  深度优先查询
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

/**
 * 第一版本
 */
/*class Solution {
    int sum = 0 ;
    List<Integer> temp = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        DFS(root);
        return sum;
    }

    private void DFS(TreeNode root) {
        temp.add(root.val);
        if(root.left == null && root.right == null){
            sum += creat(temp);
        }
        if(root.left != null){
            DFS(root.left);
        }
        if(root.right != null){
            DFS(root.right);
        }
        temp.remove(temp.size() - 1);
    }

    private int creat(List<Integer> temp) {
        int t = 1;
        int s = 0;
        for(int i = temp.size() - 1 ; i >= 0 ; i --){
            s += temp.get(i) * t;
            t *= 10;
        }
        return s;
    }
}*/
/**
 * 优化结构
 */

class Solution {
    public int sumNumbers(TreeNode root) {
        return DFS(root , 0);
    }

    private int DFS(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int newsum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return newsum;
        }else {
            return DFS(root.left , newsum) + DFS(root.right , newsum);
        }
    }
}

