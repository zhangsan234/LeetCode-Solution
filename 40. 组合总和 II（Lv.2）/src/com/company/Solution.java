package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/10 8:47
 */

/**
 * @problem
 *给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * @example
 *
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 *
 * @idea
 *  本题无法使用普通的 递归+回溯,因为其无法满足题目中的去重。
 *  例如：例如当 candidates=[2,2],target=2 时，上述算法会将列表 [2][2] 放入答案两次。
 *  因此我们可以将 candidates 中的元素进行排序,用哈希表 fer 记录下每个元素出现的次数.
 *  对于fer的 k 进行 进行遍历,如果当前 k 存在 n 次 , 则可以递归 n 次 , 每次多添加一个n , 但k的总和不能大于当前剩余的 target .
 *
 *  优化: 因为当前的fer是经过排序的数组,所以若当前元素 fer.get(index)[0] > target ,则结束递归
 */

class Solution {
    private List<int[]> fer = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i : candidates){
            int size = fer.size();
            if(fer.isEmpty() || i != fer.get(size - 1)[0]){
                fer.add(new int[]{i , 1});
            }else{
                ++fer.get(size - 1)[1];
            }
        }
        DFS( target , 0);
        return ans;
    }

    private void DFS(int target, int index) {
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        if(index == fer.size() || fer.get(index)[0] > target){
            return ;
        }


        //不选取当前节点
        DFS(target , index + 1);

        //选取当前节点
        int most = Math.min(fer.get(index)[1] , target / fer.get(index)[0]);
        for(int i = 1 ; i <= most ; i++){
            temp.add(fer.get(index)[0]);
            DFS(target - i * fer.get(index)[0] , index + 1);
        }
        for(int i = 1 ; i <= most ; i++){
            temp.remove(temp.size() - 1);
        }
    }
}
