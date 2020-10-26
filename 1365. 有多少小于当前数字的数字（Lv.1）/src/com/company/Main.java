package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        int[] ints = {7,3,8,3,6,8};
        int[] ints1 = solution.smallerNumbersThanCurrent(ints);
        for(int i : ints1){
            System.out.print(i + "       ");
        }
        System.out.println();
    }
}
