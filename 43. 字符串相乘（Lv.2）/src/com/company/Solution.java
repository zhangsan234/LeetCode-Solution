package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/13 11:34
 *
 * @problem
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @example
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * @idea
 * 数学法
 * 在num1 * num2 中，
 * 用一个int型变量表示每一位的进值add.
 * num2的数 ，每进一位都需要在字符的最后加一个‘0’；
 *
 */

class Solution{
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length() - 1, n = num2.length() - 1;
        String ans = "0";
        for(int i =  n ; i >= 0 ; --i){
            int x = num2.charAt(i) - '0';
            int add = 0;
            StringBuffer curr = new StringBuffer();
            for(int j = n ; j > i ; --j){
                curr.append(0);
            }
            for(int j = m ; j >= 0 ; --j){
                int y = num1.charAt(j) - '0';
                int p = x * y + add;
                curr.append(p % 10);
                add = p / 10;
            }
            if(add != 0){
                curr.append(add % 10);
            }
            ans = sum(ans,curr.reverse().toString());
        }
        return ans;
    }

    private String sum(String num1, String num2) {
        int n = num1.length() - 1 , m = num2.length() - 1 , add = 0;
        StringBuffer ans = new StringBuffer();
        while(n >= 0 || m >=0 || add != 0){
            int x = n >= 0 ?num1.charAt(n) - '0':0;
            int y = m >= 0 ?num2.charAt(m) - '0':0;
            int p = x + y + add;
            ans.append(p % 10);
            add = p / 10;
            --n;
            --m;
        }
        return ans.reverse().toString();
    }
}
