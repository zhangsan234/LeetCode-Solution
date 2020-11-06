package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[] ints = solution.sortByBits(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        for(int i : ints){
            System.out.print(i + "   ");
        }
        System.out.println();
    }
}
