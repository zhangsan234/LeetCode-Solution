package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/17 12:40
 */


import java.util.HashSet;
import java.util.Set;

/**
 * @problem
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * @example
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
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
 * @idea
 * 回溯
 * 和N皇后I 一样的解法 ， 只是需要的结果从所有的结果集，变为所有结果集的数量。
 */
class Solution {
    int ret = 0;
    public int totalNQueens(int n) {
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        Set<Integer> colume = new HashSet<>();
        back(colume , diagonals1 , diagonals2 , n , 0 );
        return ret;
    }

    private void back(Set<Integer> colume, Set<Integer> diagonals1, Set<Integer> diagonals2, int n, int rew) {
        if(n == rew){
            ret ++ ;
        }else {
            for(int i = 0 ; i < n ; i++){
                if(colume.contains(i)){
                    continue;
                }
                int d1 = i - rew;
                if(diagonals1.contains(d1)){
                    continue;
                }
                int d2 = i + rew;
                if(diagonals2.contains(d2)){
                    continue;
                }
                colume.add(i);
                diagonals1.add(d1);
                diagonals2.add(d2);
                back(colume , diagonals1 , diagonals2 , n ,rew + 1 );
                colume.remove(i);
                diagonals1.remove(d1);
                diagonals2.remove(d2);
            }
        }
    }
}
