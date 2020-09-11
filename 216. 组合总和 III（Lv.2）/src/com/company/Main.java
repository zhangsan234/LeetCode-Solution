package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum3(3, 6);
        System.out.println(lists);
    }
}
