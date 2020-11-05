package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[][] intervals = new int[][]{
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newintervals = new int[]{4,8};
        solution.insert(intervals , newintervals);
    }
}
