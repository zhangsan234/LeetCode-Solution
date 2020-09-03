package com.company;

import java.util.*;

/**
 * @author Zhangsan
 * @date 2020/9/3 10:11
 */

/**
 * @problem
 *n 皇后问题研究的是如何将 n 个皇后放置给定一个整数 n，返回所有不同的皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @example
 *输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * @idea
 *  集合回溯
 *  要求是皇后之间不能相互攻击，即（同一列，同一行，左斜线和右斜线上不能有其他皇后）
 *  所以可以按行穷举，并用三个集合分别记录：
 *  1.哪些列上已经有皇后
 *  2.哪些左斜线已经有皇后
 *  3.哪些右极限已经有皇后
 *
 *  只有所在的列，左斜线，右斜线上都没有点，才能记录为皇后（每一行穷举时，每次只能选出一个皇后）
 *
 *  当前结果如果最后满足要求，加入结果集中，进行回溯。
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1  = new HashSet<Integer>();
        Set<Integer> diagonals2  = new HashSet<Integer>();
        backtrack(ans,queens,n,0,columns,diagonals1,diagonals2);
        return ans;
    }

    private void backtrack(List<List<String>> ans, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(n == row){
            ans.add(generateBoard(queens,n));
        }else {
            for(int i = 0 ; i < n ; i++) {
                if(columns.contains(i)){
                    continue;
                }
                int d1 = row - i ;
                if(diagonals1.contains(d1)){
                    continue;
                }
                int d2 = row + i ;
                if(diagonals2.contains(d2)){
                    continue;
                }
                queens[row] = i ;
                columns.add(i);
                diagonals1.add(d1);
                diagonals2.add(d2);
                backtrack(ans,queens,n,row + 1,columns,diagonals1,diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(d1);
                diagonals2.remove(d2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> ans = new LinkedList<String>();
        for(int i = 0 ; i < n ; i++){
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            ans.add(new String(chars));
        }
        return ans;
    }
}
