package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/24 10:37
 */

/**
 * @problem
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @example
 * 输入: "abab"
 *
 * 输出: True
 *
 * 输入: "aba"
 *
 * 输出: False
 *
 * @idea
 *
 * 枚举
 * 按照字符串长度 枚举出可能出现的所有字符串，
 * 对于取出的字符串s‘  其长度为n’ 原字符串s 其长度为n
 * 若s是由多个子字符串重复构成，那么它和该子字符串的关系应该为：
 *  1.n’ 一定可以被 n 整除；
 *  2.n‘ 一定是s的前缀;
 *  3.对于任意的i属于[n',n)都有s[i] = s[i - n'];(周期性)
 *
 *  优化：n’的最大取值 应该为 n / 2 ；
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = 1 ; i * 2 <= n ; i++){
            if ( n % i == 0) {
                boolean issame = true;
                for(int j = i ; j < n ; j++){
                    if(s.charAt(j) != s.charAt(j - i)){
                        issame = false;
                        break;
                    }
                }
                if(issame){
                    return true;
                }
            }
        }
        return false;
    }
}
