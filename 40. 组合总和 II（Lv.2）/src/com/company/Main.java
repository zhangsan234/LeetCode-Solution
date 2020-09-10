package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}

