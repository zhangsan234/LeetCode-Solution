package com.company;

/**
 * @problem
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @example
 *输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 *
 * @idea
 *  深度优先查询
 *
 */


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)return true;
        else if(p==null || q == null)return false;
        else if(p.val != q.val)return false;
        else {
            return isSameTree(q.left,p.left) && isSameTree(q.right,p.right);
        }

    }
}





public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode q = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(q,p));
    }
}
