package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/1 12:19
 */

/**
 * @problem
 *小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y，
 * 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，
 * 但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * @example
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 * @idea
 * 动态规划
 * 可以将所有节点划分为三个区域：左红色区域 ， 中黄色区域 ， 右红色区域
 *  对于每个节点都有三种状态：
 *      0状态：当前节点属于左红色区域的节点
 *      1状态：当前节点属于中黄色区域的节点
 *      2状态：当前节点属于右红色区域的节点
 *  使用dp[i][j]记录第i个节点变成j状态最少需要的步骤
 *  所以状态转移方程式为：
 *      0状态下：
 *      0状态应该为前一个节点的0状态 + 当前节点变成0状态的步骤
 *      dp[i][0] = dp[i - 1][0] + isyellow;
 *      1状态下:
 *      1状态可以分为两种情况：前一个节点已经是1状态 ， 前一个节点是0状态
 *      1状态应该是两种情况的最小值 + 当前节点变为1的最小步骤
 *      dp[i][1] = min(dp[i - 1][0] , dp[i - 1][1]) + isred;
 *      2状态下：
 *      同1：
 *      dp[i][2] = min(dp[i - 1][1] , dp[i - 1][2]) + isyellow;
 *
 *      isred , isyellow 是判断当前颜色是否需要转换
 *
 *      最后dp[len - 1][2]就是需要的结果
 *      注意；
 *      因为题目要求三种情况都要有
 *      所以i > j
 */
class Solution {
    public int minimumOperations(String leaves) {
        int len = leaves.length();
        int[][] dp = new int[len][3];
        dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for(int i = 1 ; i < len ; i++){
            int isred = leaves.charAt(i) == 'r' ? 1 : 0 ;
            int isyellow = leaves.charAt(i) == 'y' ? 1 : 0 ;
            dp[i][0] = dp[i - 1][0] + isyellow;
            dp[i][1] = Math.min(dp[i - 1][0] , dp[i - 1][1]) + isred;
            if(i >= 2){
                dp[i][2] = Math.min(dp[i - 1][1] , dp[i - 1][2]) + isyellow;
            }
        }
        return dp[len - 1][2];
    }
}
