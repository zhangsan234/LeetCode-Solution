package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/28 10:25
 */

import java.util.HashMap;

/**
 * @problem
 *在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 *
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 *
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 * @example
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 *
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 *
 * @idea
 * 模拟
 用一个x ，y 记录在某个方向上走的步数；最后都等于0代表回到原位
 */
class Solution {

    /*  剪枝：
    nt了，这么写时间复杂度都太高了  太多字符串了！！！！！！！
    HashMap<String,String> map = new HashMap<String,String>();
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0 )return true;
        map.put("U","D");
        map.put("D","U");
        map.put("L","R");
        map.put("R","L");
        while(moves.length() != 0){
            String s = map.get(String.valueOf(moves.charAt(0)));
            int i = moves.indexOf(s);
            if(i != -1){
                moves = moves.substring(1,i) + moves.substring(i + 1);
            }else {
                return false;
            }
        }
        return true;
    }
     */

    /**
     * 机器模拟
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int x = 0 , y = 0 ;
        for(int i = 0 ; i < moves.length() ; ++i){
            char c = moves.charAt(i);
            if (c == 'U') {
                y++;
            } else if (c == 'D'){
                y--;
            } else if (c == 'L') {
                x--;
            } else if (c == 'R'){
                x++;
            }
        }
        return x == 0 && y == 0;
    }
}
