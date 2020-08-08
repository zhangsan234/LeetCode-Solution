package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(1,new TreeNode(3,null,new TreeNode(2)),null);
        Solution solution = new Solution();
        solution.recoverTree(root);
        printf(root);
    }
    public static void printf(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            printf(root.left);
            printf(root.right);
        }

    }
}
