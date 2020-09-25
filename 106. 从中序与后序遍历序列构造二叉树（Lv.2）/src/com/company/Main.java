package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums1 = {9,3,15,20,7};
        int[] nums2 = {9,15,7,20,3};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(nums1, nums2);
        System.out.println(treeNode);
    }
}
