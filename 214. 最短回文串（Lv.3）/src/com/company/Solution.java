package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/29 10:33
 */

/**
 * @problem
 *给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * @example
 *输入: "aacecaaa"
 * 输出: "aaacecaaa"
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * @idea
 * 马拉车算法 找最长的回文串前缀 注：“字符串非常长时 超时”
 */
class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.equals(""))return "";
        StringBuilder ans = new StringBuilder("#");
        int index = 0;
        for(int i = 0 ; i < s.length() ; i++){
            ans.append(s.charAt(i)+"#");
        }
        System.out.println(ans);
        for(int i = ans.length() / 2 ; i >= 1 ; i --){
            if(isPalindrome(i,ans)){
                index = i;
                break;
            }
        }
        System.out.println(index);
        return  new StringBuffer(s.substring(index)).reverse().toString() + s;
    }
    public boolean isPalindrome(int index,StringBuilder ans){
        for(int i = 0 ; i <= index ; i++){
            if(ans.charAt(index - i) != ans.charAt(index + i)){
                return false;
            }
        }
        return true;
    }
}
