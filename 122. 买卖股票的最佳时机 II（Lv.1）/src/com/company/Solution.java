package com.company;

/**
 * @author Zhangsan
 * @date 2020/11/8 22:44
 */


/**
 * @problem
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 * @example
 * 测试用例1：
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
 *
 *
 * 测试用例2：
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @idea
 * 动态规划：
 *  dp[i][0]:表示第i天,不持有该股票的最大收益
 *  dp[i][1]:表示第i天,持有该股票的最大收益
 *
 *  第i天不持有该股票的收益明细分为两种情况:
 *      1.第 i - 1 天手中没有持有股票
 *      2.第 i - 1 天手中持有该股票,第i天将股票出售
 *  可以推出dp[i][0]的动态规划方程式为:
 *      dp[i][0] = MAX(dp[i - 1][0] , dp[i - 1][1] + prices[i])
 *
 *  第i天持有该股票的收益明细分为两种情况:
 *      1.第 i - 1 天手中持有该股票,收益不变
 *      2.第 i - 1 天手中不持有该股票,第i天购买该股票
 *  可推出dp[i][1]的动态规划方程式为:
 *      dp[i][1] = MAX(dp[i - 1][1] , dp[i - 1][0] - prices[i])
 *
 *  最后返回最后一天的dp[i][0]即可
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1 ; i  < prices.length ; i ++){
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1] , dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}