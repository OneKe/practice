package algorithm.day39;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 说明:
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 */
public class Part0332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        LinkedList<String> ans = new LinkedList<>();

        if (tickets == null || tickets.size() == 0)
            return ans;

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }

        // 按目的顶点排序

        visit(graph, "JFK", ans);

        return ans;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {

        Stack<String> stack = new Stack<>();

        stack.push(src);

        while (!stack.isEmpty()) {
            PriorityQueue<String> nbr;
            while ((nbr = graph.get(stack.peek())) != null && nbr.size() > 0) {
                stack.push(nbr.poll());
            }
            ans.add(0, stack.pop());
        }
    }
}
