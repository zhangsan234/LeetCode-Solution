package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem
 *
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * @example
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * @idea
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

public class Solution {
    public void recoverTree(TreeNode root) {
        //存放遍历之后的结果
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root,nums);
        int[] a = finderror(nums);
        recover(root,2,a[0],a[1]);
    }

    private void recover(TreeNode root, int i, int x, int y) {
        if(root != null){
            if(root.val == x || root.val == y){
                root.val = root.val == x?y:x;
                if( --i == 0 ){
                    return;
                }
            }
            recover(root.right,i,x,y);
            recover(root.left,i,x,y);
        }
    }

    //二叉树的中序遍历
    private void inorder(TreeNode root, List<Integer> nums) {
        if(root == null)
            return;
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
    //寻找错误位置
    private int[] finderror(List<Integer> nums) {
        int x = -1 , y = -1;
        int n = nums.size();
        for(int i = 0 ; i < n ; ++i){
            if(nums.get(i+1) < nums.get(i)){
                y = nums.get(i+1);
                if(x == -1){
                    x = nums.get(i);
                }else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
}
