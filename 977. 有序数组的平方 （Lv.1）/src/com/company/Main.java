package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[] ints = solution.sortedSquares(new int[]{ -2 , 1, 2, 3, 4, 5});
        for(int i : ints){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
