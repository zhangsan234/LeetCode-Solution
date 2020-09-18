import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/18 16:57
 */

/**
 * @problem
 *  给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @example
 *  输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * @idea
 *  主要存在问题就是去重.
 *  因为本题的写法是 将本题看成有 n 个长度的空格 ,向空格中分别填入数字.
 *  所以去重问题可以看成,如果当前节点已经使用了值为 x 的节点 , 那么当前节点就不可以再使用 x 节点.
 *  所以对数组nums进行排序 , 相同值的节点会排列再一起 , 每次进行节点选择时 ,对于该值的节点都从左往右选择没有被选取过的节点.
 *  最终返回结果集
 *
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //结果集
        ans = new ArrayList<List<Integer>>();
        //当前集合
        List<Integer> temp = new ArrayList<Integer>();
        //记录节点的选择情况
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        //开始回溯
        back(temp , nums , vis , 0);
        return ans ;
    }

    private void back(List<Integer> temp, int[] nums, boolean[] vis, int index) {
        //合法结果
        if(temp.size() ==  nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                continue;
            }
            vis[i] = true;
            temp.add(nums[i]);
            back(temp , nums , vis , index + 1);
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
}