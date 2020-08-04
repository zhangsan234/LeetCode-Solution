package com.company;

/*
    题目:
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

    注意:
    num1 和num2 的长度都小于 5100.
    num1 和num2 都只包含数字 0-9.
    num1 和num2 都不包含任何前导零。
    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

 */


class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1 ,  j = num2.length()-1 , add = 0 ;
        StringBuilder res = new StringBuilder();
        while(i>= 0 || j>= 0){
            int x = i>=0 ?num1.charAt(i)-'0':0;
            int y = j>=0 ?num2.charAt(j)-'0':0;
            int tmp = x + y + add;
            add = tmp / 10 ;
            res.append(tmp%10);
            --i;
            --j;
        }
        System.out.println();
        if(add == 1)res.append(1);
        return res.reverse().toString();
    }
}

public class Main {


    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        System.out.println(solution.addStrings("321","789"));
    }
}
