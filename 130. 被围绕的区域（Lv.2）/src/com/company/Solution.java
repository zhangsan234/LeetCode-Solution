package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/8/11 10:56
 * @problem
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @example
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * @idea
 *  对于矩阵中没有被X包围的0元素，都与边界上的0元素有直接或者间接的连接。
 *  所以我们可以遍历矩阵的边缘，然后对边缘上的0元素进行深度优先查询，将其周围的0元素做上标记
 *  最后遍历整个矩阵，将有没有标记的0元素全部转化为X，将有标记的0元素去除标记即可。
 */
public class Solution {
    int n , m ;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        if(n == 0 || m == 0){
            return ;
        }
        for(int i = 0 ; i < m ; ++i){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int i = 1 ; i < n-1 ; ++i){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                if(board[i][j] == '0'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'A'){
                    board[i][j] = '0';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n || board[y][x] != '0'){
            return;
        }
        board[y][x] = 'A';
        dfs(board,x-1,y);
        dfs(board,x,y-1);
        dfs(board,x+1,y);
        dfs(board,x,y+1);
    }
}
