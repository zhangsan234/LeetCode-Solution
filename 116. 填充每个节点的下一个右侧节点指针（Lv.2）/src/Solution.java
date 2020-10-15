/**
 * @author Zhangsan
 * @date 2020/10/15 12:31
 */

/**
 * @problem
 *给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * @example
 *
 * 输入：
 * [1,2,3,4,5,6,7]
 *输出：
 * [1,#,2,3,#,4,5,6,7,#]
 *
 * @idea
 * 层级递归：
 * 将当前层的两个处理完，递归到下一层继续处理，因为上一层处理了两个，能判断子右节点的next的值
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if(root == null)return null;
        if(root.left != null){
            root.left.next = root.right;
            root.right.next = root.next != null ? root.next.left : null;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}
