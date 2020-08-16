package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/16 10:17
 *
 * @problem
 *  有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * @example
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 *
 * @idea
 * DFS
 * 从起始位置开始，进行深度优先搜索.如果搜索的方格与初始的颜色相同，则当前方格的颜色更新，若不相同则回溯
 *
 * 若初始方格的颜色和新颜色相同，直接返回答案即可，不需要更新
 *
 *
 */
public class Solution {
    private int r = 0 , c = 0 ;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        r = image.length-1;
        c = image[0].length-1;
        DFS(image, sr, sc ,image[sr][sc], newColor);
        return image;
    }

    private void DFS(int[][] image, int sr, int sc,int curColor, int newColor) {
        if(sr >= 0 && sr <= r && sc >= 0 && sc <= c && image[sr][sc] == curColor){
            image[sr][sc] = newColor;
            DFS(image,sr+1,sc,curColor,newColor);
            DFS(image,sr-1,sc,curColor,newColor);
            DFS(image,sr,sc+1,curColor,newColor);
            DFS(image,sr,sc-1,curColor,newColor);
        }
        return ;
    }
}
