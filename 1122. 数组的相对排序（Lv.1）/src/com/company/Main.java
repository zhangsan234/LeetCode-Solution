package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[] ints = solution.relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6});
        for(int i : ints){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
