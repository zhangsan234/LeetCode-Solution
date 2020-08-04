package com.company;


class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = t.length(),n = s.length();
        int[][] word = new int[m+1][26];
        for(int i = 0 ; i < 26 ; ++i){
            word[m][i] = m ;
        }
        for(int i = m-1 ; i >= 0 ; --i){
            for(int j = 0 ; j < 26 ; ++j){
                if(t.charAt(i) == 'a'+j){
                    word[i][j] = i;
                }else{
                    word[i][j] = word[i+1][j];
                }
            }
        }
        int add = 0 ;
        for(int i = 0 ; i < n ; ++i){
            if(word[i][s.charAt(i)-'a'] == m){
                return false;
            }
            add = word[add][s.charAt(i) - 'a'] +1;
        }
    return true;
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "ac";
        String t = "abcd";
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(s,t));
    }
}
