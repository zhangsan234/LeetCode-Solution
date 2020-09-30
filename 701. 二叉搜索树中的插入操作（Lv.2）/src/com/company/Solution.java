package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/30 19:02
 */

/**
 * @problem
 *给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * @example
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 * @idea
 *  模拟
 *  如果当前节点小于根节点的放到左子树
 *  如果当前节点大于根节点的放到右子树
 *
 *  对于当前根节点
 *  左子树或者右子树为空 创建新节点连接；
 *  如果不为空，则将其作为根节点继续判断
 *
 * 最终返回根节点root
 *
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        TreeNode node = root;
        while(node != null){
            if(val < node.val){
                if(node.left == null){
                    node.left = new TreeNode(val);
                    break;
                }else {
                    node = node.left;
                }
            }else{
                if(node.right == null){
                    node.right = new TreeNode(val);
                    break;
                }else {
                    node = node.right;
                }
            }
        }
        return root;
    }
}
