package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/25 9:04
 */

import java.util.HashMap;

/**
 * @problem
 *根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * @example
 * 给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @idea
 * 递归:
 * 中序遍历的顺序是: 左 中 右
 * 后序遍历的顺序是: 左 右 中
 *
 * 所以 后续遍历的最后一个元素 就是树的根节点
 * 我们可以通过哈希表记录中序遍历的遍历顺序<key(value) , value(index)>;
 * 通过递归构建整个函数
 * 取得根节点再中序遍历中的位置之后 我们可以递归
 * 构建右子树 helper(index + 1 , right)
 * 构建左子树 helper(left , index - 1)
 * 构建顺序必须是 先右子树 ,再左子树;
 * 因为构建的树的 根 的顺序,刚好是 postorder 的倒叙.
 * 最后返回根节点
 *
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    int post_idx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        return Helper(0 , inorder.length - 1);


    }

    private TreeNode Helper(int left, int right) {
        //如果左下标大于右下标,无法构成树,不合法
        if(left > right) return null;

        //
        int post_num = postorder[post_idx];
        TreeNode root = new TreeNode(post_num);

        //获取post_num再inorder中的下标
        int index = map.get(post_num);
        post_idx --;
        //递归
        root.right = Helper(index + 1 , right);
        root.left = Helper(left , index - 1);

        return root;
    }
}