package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[] intersection = solution.intersection(new int[]{1, 2, 2, 3}, new int[]{2, 2});
        for(int i : intersection){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
