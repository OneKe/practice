package algorithm.day39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Part0332Test {
    //[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    List<List<String>> tickets = new ArrayList<>();
    List<String> part1 = new ArrayList<>();
    List<String> part2 = new ArrayList<>();
    List<String> part3 = new ArrayList<>();
    List<String> part4 = new ArrayList<>();
    List<String> part5 = new ArrayList<>();

    @Test
    public void test01() {
//        part1.add("MUC");
//        part1.add("LHR");
//        part2.add("JFK");
//        part2.add("MUC");
//        part3.add("SFO");
//        part3.add("SJC");
//        part4.add("LHR");
//        part4.add("SFO");
        part1.add("JFK");
        part1.add("SFO");
        part2.add("JFK");
        part2.add("ATL");
        part3.add("SFO");
        part3.add("ATL");
        part4.add("ATL");
        part4.add("JFK");
        part5.add("ATL");
        part5.add("SFO");
        tickets.add(part1);
        tickets.add(part2);
        tickets.add(part3);
        tickets.add(part4);
        tickets.add(part5);
        Part0332 test = new Part0332();
        List<String> itinerary = test.findItinerary(tickets);
        System.out.println(itinerary);
    }

}