package com.company;

import java.util.*;

/**
 * @author Zhangsan
 * @date 2020/11/14 12:52
 */

/**
 * @problem
 *给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * @example
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * @idea
 * 自定义比较
 * 利用 hashmap 记录 arr2 中的值对于的下标
 * 自定义 comparetor 在都不存在与map中时 ， 比较相应值，
 * 否则则比较 hashmap 中存储的值
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr2.length == 0 || arr1.length == 0){
            return arr1;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < arr2.length ; i ++){
            map.put(arr2[i] , i);
        }
        for(int i : arr1){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.containsKey(o1) || map.containsKey(o2)) {
                    int x = 0, y = 0;
                    if (!map.containsKey(o1)) {
                        x = Integer.MAX_VALUE;
                    } else {
                        x = map.get(o1);
                    }
                    if (!map.containsKey(o2)) {
                        y = Integer.MAX_VALUE;
                    } else {
                        y = map.get(o2);
                    }

                    return x - y;
                }else {
                    return o1 - o2;
                }

            }
        });
        for(int i = 0 ; i < arr1.length ; i ++){
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
