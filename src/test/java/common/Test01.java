package common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test01 {
    /**
     * 字符串转数字
     */
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strChars = str.toCharArray();
        int start = 0;
        if (strChars[0] == '-') {
            start = 1;
        }
        int sum = 0;
        for (int i = start; i < strChars.length; i++) {
            if (strChars[i] < '0' || strChars[i] > '9') {
                return 0;
            }
            sum = sum * 10 + (strChars[i] - '0');
        }
        return start == 1 ? -sum : sum;
    }

    @Test
    public void test01() {
        int i = strToInt("10234");
        System.out.println(i);
    }

    /**
     * 时针和分针夹角
     */
    public double angle(int hour, int minute) {
        double m = 6.0;
        double h = 30.0;
        double minuteAngle = minute * m;
        double hourAngle = (hour % 12 + minute / 60.0) * h;
        double a = Math.abs(minuteAngle - hourAngle);
        return Math.min(a, 360 - a);
    }

    @Test
    public void test02() {
        double angle = angle(9, 15);
        System.out.println(angle);
    }

    /**
     * min topN
     */
    public List<Integer> minTopN(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int a : arr) {
            if (queue.size() < k) {
                queue.add(a);
            } else {
                if (queue.peek() == null) {
                    continue;
                }
                if (queue.peek() > a) {
                    queue.poll();
                    queue.offer(a);
                }
            }
        }
        res.addAll(queue);
        return res;
    }

    @Test
    public void test03() {
        int[] arr = {6, 12, 60, 5, 3, 4, 1, 20, 11};
        List<Integer> integers = minTopN(arr, 3);
        System.out.println(integers);
    }
}
