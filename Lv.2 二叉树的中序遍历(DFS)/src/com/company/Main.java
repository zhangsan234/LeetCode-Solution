package com.company;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> ans ;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        DFS(root,ans);
        return ans;
    }

    private void DFS(TreeNode root, List<Integer> ans) {
        if(root != null){
            if(root.left != null){
                DFS(root.left,ans);
            }
            ans.add(root.val);
            if(root.right!=null){
                DFS(root.right,ans);
            }
        }
    }


}

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(1);
        Solution solution = new Solution();
        solution.inorderTraversal(root);
    }
}
