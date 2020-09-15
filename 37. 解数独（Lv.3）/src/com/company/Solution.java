package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/15 8:37
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @problem
 *编写一个程序，通过已填充的空格来解决数独问题。
 *
 *一个数独的解法需遵循如下规则：
 *
 *数字 1-9 在每一行只能出现一次。
 *数字 1-9 在每一列只能出现一次。
 *数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *空白格用 '.' 表示。
 * @example
 *
 * @idea
 * “行优先”思路:依次枚举每一个空白格中填写的数字
 * 使用三个数组line,culumn,bod 分别记录每一行 , 每一列 每3*3方格 里面1 ~ 9 元素的使用情况
 * 遍历整个board,如果当前元素是'.'则将其位置记录在集合space中
 * 如果不是,则将当前列,当前行 , 当前3*3方格中的该数记录.
 *
 * 然后对spaces进行递归,从1 ~ 9 中选取合法的数字,记录在三个数组总,然后递归,如果递归到最终没有数字可选,则说明当前选择的组合不正确,回溯
 * 最终没有产生冲突,则说明该种组合正确
 */
class Solution {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] bod = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();
    public void solveSudoku(char[][] board) {
        for(int i = 0 ; i < 9 ; i ++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == '.'){
                    spaces.add(new int[]{i,j});
                }else{
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = bod[i / 3][j / 3][digit] = true;
                }
            }
        }
        DFS(board , 0);
    }

private void DFS(char[][] board, int index) {
    if (index == spaces.size()) {
        valid = true;
        return;
    }
    int[] space = spaces.get(index);
    int i = space[0], j = space[1];
    for (int digit = 0; digit < 9 && !valid; ++digit) {
        if (!line[i][digit] && !column[j][digit] && !bod[i / 3][j / 3][digit]) {
            line[i][digit] = column[j][digit] = bod[i / 3][j / 3][digit] = true;
            board[i][j] = (char) (digit + '0' + 1);
                DFS(board, index + 1);
                line[i][digit] = column[j][digit] = bod[i / 3][j / 3][digit] = false;
            }
        }
    }
}
