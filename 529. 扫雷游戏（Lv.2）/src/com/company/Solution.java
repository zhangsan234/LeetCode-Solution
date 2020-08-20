package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/20 9:49
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @problem
 *让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * @example
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 *
 * @idea
 * DFS
 *三种情况：
 * 1.点击的方块是雷
 * 2.点击的方块相邻的方块是雷
 * 3.点击的方块相邻的方块没有雷
 *
 * 对于第一种情况，直接更新方块返回
 * 对于第二种和第三种情况，先搜索四周的方块，计算周围的雷总数
 * 如果大于0 则是第二种情况，直接更新方块的值。
 * 如果等于0 则是第三种情况，则递归四周的方块。
 */

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0] , x = click[1];
        char c = board[y][x];
        if(c == 'M'){
            board[y][x] = 'X';
        }else{
            DFS(board,x,y);
        }
        return board;
    }

    private void DFS(char[][] board, int x, int y) {
        //判断边界
        if(y < 0 || y > board.length -1 || x < 0 || x > board[0].length - 1 || board[y][x] != 'E')return;
        //四周地雷的总数
        int count = 0;

        int[] dx = {1,-1,0,0,1,1,-1,-1};
        int[] dy = {0,0,-1,1,1,-1,1,-1};
        //判断周围地雷的总数
        for(int i = 0 ; i < 8 ; ++i){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(ty < 0 || ty > board.length - 1 || tx < 0 || tx > board[0].length - 1){
                continue;
            }
            if(board[ty][tx] == 'M') count++;
        }
        //如果大于0 则更新该方块的值,结束
        if(count > 0)
            board[y][x] = (char)(count+'0');
        //等于0 则递归四周的方块。
        else {
            board[y][x] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                DFS(board,tx,ty);
            }
        }
    }
}
