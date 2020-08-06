package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @problem:
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * @example:
 * 输入: ["abcd","dcba","lls","s","sssll"]
 *
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 *
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 *
 * @idea:
 *  字典树
 *  如果存在一对字符串相加为回文字符串s1,s2，两个字符串的长度分别为len1，len2.他们能组成字符串的情况有三种
 *  1.len1 = len2，s1 互为 s2 的翻转
 *  2.len1 > len2.将 s1 拆为 t1，t2 其中一个为s2的翻转 ，另一个是个回文串
 *  3.len1 < len2.将 s2 拆为 t1，t2 其中一个为s1的翻转 ，另一个是个回文串
 *
 *  所以我们可以使用哈希表或者字典树记录每一个字符串，然后遍历所有字符串。
 *  遍历每个字符串时将其差分为两个字符串，分别判断他们中是否存在回文数，如果存在则判断另一个字符串的翻转是否被记录在哈希表或者字典树中
 *
 *  边界问题：
 *  对于空的字符串我们也可以将其差分为两个空的字符串，当然空字符串也属于回文字符串。
 */



class Solution {
    class Node{
        int[] ch = new int[26];
        int flag;
        public Node() {
            flag = -1;
        }
    }

    List<Node> list = new ArrayList<Node>();
    public List<List<Integer>> palindromePairs(String[] words) {
        list.add(new Node());
        int n = words.length;
        for(int i = 0 ; i < n ; ++i){
            insert(words[i],i);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < n ; ++i){
            int len = words[i].length();
            for(int j = 0 ; j <=len ; ++j){
                if(isPalindrome(words[i],j,len-1)){
                    int leftId = findword(words[i],0,j-1);
                    if(leftId != -1 && leftId != i){
                        res.add(Arrays.asList(i,leftId));
                    }
                }
                if(j != 0 && isPalindrome(words[i],0,j-1)){
                    int rightId = findword(words[i],j,len-1);
                    if(rightId != -1 && rightId != i ){
                        res.add(Arrays.asList(rightId,i));
                    }
                }
            }
        }

    return res;
    }
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findword(String s , int left ,int right){
        int add = 0;
        for(int i = right ; i >=left ; --i){
            int x = s.charAt(i) - 'a';
            if(list.get(add).ch[x] == 0){
                return -1;
            }
            add = list.get(add).ch[x];
        }
        return list.get(add).flag;
    }

    private void insert(String word, int id) {
        int len = word.length(),add = 0;
        for(int i = 0 ; i < len ; ++i){
            int x = word.charAt(i) - 'a';
            if(list.get(add).ch[x] == 0){
                list.add(new Node());
                list.get(add).ch[x] = list.size() - 1;
            }
            add = list.get(add).ch[x];
        }
        list.get(add).flag = id;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.palindromePairs(new String[]{"", "dcba", "lls", "s", "sssll"});
        for(List<Integer> a : lists){
            for(int i : a){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
