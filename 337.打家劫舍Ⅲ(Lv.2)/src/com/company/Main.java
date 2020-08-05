package com.company;
import java.util.*;

/**
 * @problem
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * @example
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * @idea
 * 运用树形动态规划+深度优先搜索
 *
 * 对于每个树节点o都有两个状态：选中状态和未选中状态
 * 对于o选中状态：o的两个子节点都不能选中，o点的最大值应该为 o点值+两个子节点的未选中时的最大值
 * 对于o的未选中状态：o的两个子节点可以选中可以未选中，所以分别取两个子节点的未选中和选中状态下的最大值；
 *
 * f(o)表示o点选中，g(o)表示o点未选中，l、r表示o点的连个子节点
 * 则f(o) = val + g(l)+g(r);
 * g(o) = max{g(l)+f(l)}+max{g(r),f(r)}
 *
 * 用哈希映射表示节点和其权值，用深度优先搜索遍历二叉树，得到根节点root的f和g即可
 */



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();
    public int rob(TreeNode root) {
        DFS(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    private void DFS(TreeNode root) {
        if(root == null){
            return;
        }
        DFS(root.left);
        DFS(root.right);
        f.put(root , root.val+ g.getOrDefault(root.left,0)+g.getOrDefault(root.right,0));
        g.put(root , Math.max(f.getOrDefault(root.right,0),g.getOrDefault(root.right,0))+Math.max(f.getOrDefault(root.left,0),g.getOrDefault(
                root.left,0
        )));
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.rob(treeNode));

    }
}
