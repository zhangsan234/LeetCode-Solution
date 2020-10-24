package com.company;

import java.util.Arrays;

/**
 * @author Zhangsan
 * @date 2020/10/24 12:22
 */


/**
 * @problem
 *你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，
 * 例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 * @example
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 *
 * @idea
 * 动态规划：
 *  dp[i] 表示到 i 这个点  需要的最小步骤。
 *  因为dp[i] 代表到 i 的最小步骤 , 所以需要将 dp 填满最大值Integer.MAX_VALUE;
 *  将clips遍历一遍,找到能包含 i 的区间。
 *  dp[i] 可能有两个值 :
 *      1.当前dp[i].
 *      2.dp[clip[0]](到clip[0]的最小步骤) + 1.
 *
 *  完成动态转移方程式:
 *      dp[i] = min(dp[i] , dp[clip[0]] + 1);
 *
 *  最后返回dp[T]的值,若为Integer.MAX_VALUE 则表示没法移动这个点,返回 -1 , 否则则返回 dp[T].
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        int dp[] = new int[T + 1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0 ; i <= T ; i ++){
            for(int[] clip : clips){
                if(clip[0] <= i && i <= clip[1] ){
                    dp[i] = Math.min(dp[i] , dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
    }
}
