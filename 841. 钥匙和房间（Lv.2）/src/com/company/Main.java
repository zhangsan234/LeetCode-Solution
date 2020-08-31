package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        List<List<Integer>> lists = new LinkedList<>();

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(2);
        LinkedList<Integer> list4 = new LinkedList<>();
        list4.add(1);list4.add(3);list4.add(1);
        lists.add(list1);lists.add(list2);lists.add(list3);lists.add(list4);


        System.out.println(solution.canVisitAllRooms(lists));
    }
}
