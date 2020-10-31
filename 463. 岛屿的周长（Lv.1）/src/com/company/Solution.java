package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/30 16:36
 */


/**
 * @problem
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * @example
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * @idea
 * 深度优先搜索：
 *  寻找到一个为 1 的元素 ，就通过该点进行搜索 ， 碰见 0 元素，停止搜索，并返回 1  ， 并将该值为 1 的元素 记录为 已经搜索，继续向下搜索
 */
class Solution {
    private int n , m ;
    int[] dx = {1 , -1 , 0 , 0};
    int[] dy = {0 , 0 , 1 , -1};
    public int islandPerimeter(int[][] grid) {
        int c = 0 ;
        n = grid.length;
        m = grid[0].length;
        for(int y = 0 ; y < n ; y++){
            for(int x = 0 ; x < m ; x++){
                if(grid[y][x] == 1){
                    c += DFS(x , y , grid , n , m);
                }
            }
        }
        return c;
    }

    private int DFS(int x, int y, int[][] grid, int n, int m) {
        if (y < 0 || y >= n || x < 0 || x >= m || grid[y][x] == 0) {
            return 1;
        }
        if (grid[y][x] == 2) {
            return 0;
        }
        grid[y][x] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int ty = y + dy[i];
            int tx = x + dx[i];
            res += DFS(tx, ty, grid, n, m);
        }
        return res;
    }
}
