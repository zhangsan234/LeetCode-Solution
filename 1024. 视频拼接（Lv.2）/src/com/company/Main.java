package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] ints = new int[][]{
                {0,2},
                {4,6}
        };
        Solution solution = new Solution();
        int i = solution.videoStitching(ints, 10);
        System.out.println(i);
    }
}
