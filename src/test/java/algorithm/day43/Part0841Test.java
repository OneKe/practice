package algorithm.day43;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Part0841Test {
    @Test
    public void test01() {
        //[[1],[2],[3],[]]
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(1);
        list2.add(2);
        list3.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        Part0841 test = new Part0841();
        boolean b = test.canVisitAllRooms(lists);
        System.out.println(b);
    }
}