package com.company;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        //纵列
        int nr = grid.length;
        //横列
        int nc = grid[0].length;
        //记录岛屿数量
        int num_islands = 0;
        //遍历
        for(int i = 0;i<nr;i++){
            for(int j = 0;j<nc;j++){
                if(grid[i][j] == '1'){
                    num_islands++;
                    dfs(grid,i,j);
                }
            }
        }


        return num_islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        //判断边界问题
        if(r<0 || c<0 || r>=nr || c>= nc || grid[r][c] == '0'){
            return;
        }

        grid[r][c]  = '0';
        //递归 遍历周围相邻节点
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','0','1','0'},
                {'1','1','0','1','0'}
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));

    }
}
