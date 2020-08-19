package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/19 11:01
 *
 * @problem
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * @example
 *输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * @idea
 * 对于字符串S, 在每个字符之间添加"#"得出新的字符串s,对字符串s中的的每个字符进行中心扩展，除了中心点以外每出现一次"#"代表存在一个新的回文字符串，回文字符串总数+1。
 * Manacher可以解决奇数长度和偶数长度的回文字符串的问题
 *
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        StringBuffer rs = new StringBuffer();
        for(int i = 0 ; i < n ; ++i){
            rs.append("#");
            rs.append(s.charAt(i));
        }
        rs.append("#");
        n = rs.length();
        int ans = 0 ;
        int[] f = new int[n];
        for(int i = 1 ; i < n - 1 ; ++i){
            for(int add = 1 ; i - add >= 0 && i + add <= n - 1; add++){
                if(rs.charAt(i - add) == rs.charAt(i + add)){
                    if(rs.charAt(i - add) == '#') {
                        ans++;
                    }
                }else{
                    break;
                }
            }
        }

    return ans;
    }
}
