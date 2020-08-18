package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/18 10:53
 *
 * @problem
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @example
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @idea
 * 分治
 * 通过链表的左端点left和右端点right算出中间节点mid，此点作为根节点，左右节点总数不会超过一个，能保持平衡。（包含关系应该是左闭右开，这样不就
 * 不会在往后的遍历中将中间节点计算到左子树中，而右端点的right最开始应该为null）
 * 通过相同方法，递归计算出root的左子树和右子树。
 * 最后将根节点root返回得出答案。
 *
 *计算中间节点可以通过快慢指针的方式。
 */



class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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
    public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head,null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if(left == right)return null;
        ListNode mid = Getmid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left,mid);
        root.right = buildTree(mid.next,right);
        return root;
    }

    private ListNode Getmid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while(fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
