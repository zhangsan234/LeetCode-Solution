package com.company;

import java.util.HashSet;

/**
 * @author Zhangsan
 * @date 2020/10/20 19:11
 */

/**
 * @problem
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @example
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @idea
 * 滑动窗口
 *
 * 以 (a)bcabcbb 开始的最长字符串为  (abc)abcbb；
 * 以 a(b)cabcbb 开始的最长字符串为  a(bca)bcbb；
 * 以 ab(c)abcbb 开始的最长字符串为  ab(cab)cbb；
 * 以 abc(a)bcbb 开始的最长字符串为  abc(abc)bb；
 * 以 abca(b)cbb 开始的最长字符串为  abca(bc)bb；
 * 以 abcab(c)bb 开始的最长字符串为  abcab(cb)b；
 * 以 abcabc(b)b 开始的最长字符串为  abcabc(b)b；
 * 以 abcabcb(b) 开始的最长字符串为  abcabcb(b)。
 *
 * 依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 kk 个字符作为起始位置，
 * 并且得到了不包含重复字符的最长子串的结束位置为 r_kr 。那么当我们选择第 k+1k+1 个字符作为起始位置时，首先从 k+1k+1 到 r_kr 的字符显然是不重复的，
 * 并且由于少了原本的第 kk 个字符，我们可以尝试继续增大 r_kr ， 直到右侧出现了重复字符为止。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max_len = 0;
        int right = 0 ,len = 0 ;
        for(int i = 0 ; i < s.length() ; i ++){
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right ++;
                len ++;
            }
            max_len = Math.max(len , max_len);
            len -- ;
            set.remove(s.charAt(i));
        }
    return max_len;
    }
}
