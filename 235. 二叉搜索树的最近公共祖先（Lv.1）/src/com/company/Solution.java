package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/27 10:16
 */

/**
 * @problem
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @example
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @idea
 *  两种方法：
 *   1.递归 对于公共祖先 root ，两个节点 p ， q 必须分别大于 root ,小于 root 。
 *      如果两个节点都小于 root ， 则说明其公共节点在root的左子树 ，递归root.left
 *      如果两个节点都大于 root ， 则说明其公共节点在root的右子树 , 递归root.right
 *      如果不满足上面的两种情况 ， 说明当前节点就是其公共节点
 *
 *   2.两次遍历
 *      使用两个集合分别记录从根节点 root 到 p ，q 分别走过的路径
 *      遍历两个集合 寻找相同的节点，并且尽可能使他们的下标最大（下标其实就是其深度）
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    //递归比较简单 就直接使用递归了
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left , p , q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right , p , q);
        }
        return root;
    }
}
