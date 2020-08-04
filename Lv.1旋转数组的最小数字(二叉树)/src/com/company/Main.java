package com.company;
class Solution {
    public int minArray(int[] numbers) {
        int low = 0,high = numbers.length-1;
        while(low<high){
            int p = ((high - low)>>1) + low ;
            if(numbers[p]<numbers[high]){
                high = p;
            }else if(numbers[p]>numbers[high]){
                low = p+1;
            }else{
                high -= 1;
            }
        }return numbers[low];
    }
}
public class Main {
    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        System.out.println(solution.minArray(new int[]{4,5,6,1,2,4}));
    }
}
