package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/24 9:00
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @problem
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @example
 *输入：BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 输出：[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @idea
 * 普通：
 *  可以使用普通的中序遍历，得到一个排序过后的数组，使用哈希表记录下个元素出现的次数，找到出现次数最多的元素
 * 但是这种写法的空间复杂度为 O(n) 占有空间比较多。
 *  进阶：通过morris中序遍历
 *  morris中序遍历
 *  对于每一个后驱节点的右子叶节点(如果没有右叶子树 ,那就是当前节点自己)斗都与前驱节点连接
 *  遍历顺序为:
 *      找到左叶子节点,记录;
 *      通过前驱节点与父节点的连接找到父节点,将父节点记录
 *      遍历pre的右子树,
 *      右子树遍历到最后会通过连接,找到父节点,将父节点记录.
 *      遍历pre的右子树.
 *      ...
 *      最终遍历完所有子树.
 *  因为只用了有限量的内存记录 当前节点 和 前驱节点 . 所以空间复杂度为 O(1);
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    int maxcount , count , base ;
    List<Integer> ans = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        TreeNode cur = root,pre;
        while(cur != null){
            //用于将左子叶节点记录
            if(cur.left == null){
                update(cur.val);
                cur = cur.right;
                continue;
            }
            //获取当前节点的左后驱节点,因为事先已经判断出了当前节点左节点不为空
            pre = cur.left;
            //判断前驱节点的右节点
            while(pre.right != null && pre.right != cur){
                pre = pre.right;
            }
            //如多为空则说明第一次遍历到该节点 将该节点链接到当前节点的父节点上
            if(pre.right == null){
                pre.right = cur;
                cur = cur.left;
            }
            //第二次遍历到该节点(该节点为当前遍历子树的根节点) , 将其与父节点的连接切断
            else{
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] ret = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }

    public void update(int x){
        if(x == base){
            count++;
        }else{
            base = x ;
            count = 1;
        }
        if(count == maxcount){
            ans.add(base);
        }
        if(count > maxcount){
            ans.clear();
            ans.add(base);
            maxcount = count;
        }

    }
}