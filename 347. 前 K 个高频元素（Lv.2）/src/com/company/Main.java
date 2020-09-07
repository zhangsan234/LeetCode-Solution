package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(new int[]{1, 3, 5, 6, 8, 5, 4, 4, 4}, 3);
        for(int i : ints){
            System.out.println(i);
        }
    }
}
