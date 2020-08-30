package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/30 13:19
 */

/**
 * @problem
 *给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @example
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * @idea
 * 额外空间+倒叙
 * 使用新的空字符串ans，用于承载结果字符串
 * 将字符串反转，从字符串最后开始遍历，两个指针分别指向当前字符（cur）和最后一个字符（last）
 * 每当cur遇到一个“ ”，就将后面的字符串S[cur,last]放入s1，最后再添加一次字符串（因为字符的最开始是没有“ ”空格的）。
 */
class Solution {
    public String reverseWords(String s) {
        if(s.equals("") || s == null)return s;
        String s1 = new StringBuilder(s).reverse().toString();
        int cur = s1.length() - 1;
        int last = cur;
        StringBuilder ans = new StringBuilder();
        while(cur > 0){
            if(s1.charAt(cur) == ' '){
                ans.append(s1.substring(cur + 1 , last + 1));
                ans.append(" ");
                last = cur - 1;
            }
            cur -- ;
        }
        ans.append(s1.substring(cur , last + 1));
        return ans.toString();
    }
}