package com.company;

/*
    题目: 01 矩阵

    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
 */

/*思路（多源广度优先遍历）
    将数组遍历，如果元素为0，则将改元素的下标入列，若不为0，则换成-1;
    取队列中的元素，遍历其周围的元素，若存在切其值为-1，则为该点赋值为其父元素的值加一;
    最终返回整个数列
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int c = matrix[0].length,m = matrix.length;
        //将数值为0的元素入列，不为0的元素数值改为-1
        for(int i = 0 ; i < m; ++i){
            for(int j = 0 ; j< c;++j){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        //广度优先遍历
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0],y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX>= 0 && newX<m && newY >= 0 && newY < c && matrix[newX][newY] == -1){
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return matrix;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        Solution solution = new Solution();
        int [][] a = solution.updateMatrix(new int[][]{
                {0,0,0},
                {0,1,0},
                {1,1,1}
        });
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println("");
        }
    }
}
