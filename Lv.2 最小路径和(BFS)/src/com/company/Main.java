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


import java.util.HashSet;

/*
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid[0].length, n = grid.length;
        return minPathSumDfs(m-1, n-1, new Integer[n][m], grid);
    }

    private int minPathSumDfs(int m, int n, Integer[][] cache, int[][] grid){
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        if(m == 0 && n == 0) return grid[n][m];
        if(cache[n][m] != null ) return cache[n][m] ;
        int sum = Math.min(minPathSumDfs(m - 1, n, cache, grid), minPathSumDfs(m, n - 1, cache, grid));
        cache[n][m] = sum + grid[n][m] ;
        return cache[n][m];
    }
}
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null ||grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length,col = grid[0].length;
        return minPathSumBFS(row-1,col-1,grid,new int[row][col]);


    }
    public int minPathSumBFS(int row ,int col,int[][] grid, int[][] chas){
        int sum = 0;
        if(chas[0][0] == 0 ) chas[0][0] = grid[0][0];
        if(row<0 || col <0) return Integer.MAX_VALUE;
        if(row == 0 && col == 0)return chas[row][col];
        if(chas[row][col] != 0 ) return chas[row][col];

        sum = Math.min(minPathSumBFS(row-1,col,grid,chas),minPathSumBFS(row,col-1,grid,chas));

        chas[row][col] = sum + grid[row][col];
        return chas[row][col];
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},

        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }
}
