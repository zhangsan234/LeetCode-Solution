package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[][] i = solution.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
        for(int a = 0 ; a < i.length ; a++){
            for(int j : i[a]){
                System.out.print(j+"   ");
            }
            System.out.println();
        }
    }
}
