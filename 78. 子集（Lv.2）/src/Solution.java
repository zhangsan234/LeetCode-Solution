import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/20 11:02
 */

/**
 * @problem
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * @example
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @idea
 * 普通回溯
 * 只需要考虑选取当前节点和不选取当前节点就可以了
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1 , 2 , 3 , 4}));
    }

    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    ArrayList<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums,0);
        return res;
    }

    private void back(int[] nums, int index) {
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return ;
        }
        //不选取当前节点
        back(nums,index + 1);
        //选取当前节点
        temp.add(nums[index]);
        back(nums , index + 1);
        temp.remove(temp.size() - 1);
    }
}
