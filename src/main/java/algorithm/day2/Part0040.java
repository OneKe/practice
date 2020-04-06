package algorithm.day2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Part0040 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null) {
            return null;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] getNumber(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return null;
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.offer(arr[i]);
            } else {
                if (queue.peek() == null) {
                    continue;
                }
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        for (Integer c : queue) {
            result[index++] = c;
        }
        return result;
    }
}
