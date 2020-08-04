package com.company;

/* 题目
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
 */

/* 示例
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */

/* 思路
 使用动态规划;
 new一个二维数组dp[i][j]表示到[i][j]点的最短路径，当前点的最短路径的值应该是，其上一个元素和左边元素的dp值的最小值加上这一点原有的数值

 步骤：先将dp[][]的左边和上边初始化，然后再对整个数组遍历

 边界问题：当grid为null或者数grid的长度或者宽度为0时，return 0;

 */

class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 1;i<row;i++){
            dp[i][0] = dp[i-1][0] +grid[i][0];
        }
        for(int i = 1;i<col;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] grid = new int[][]{
                {1,3,1,2},
                {1,5,1,2},
                {4,2,1,3}
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }
}
