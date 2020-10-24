package algorithm.day90;

/**
 * 1024. 视频拼接
 * <p>
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
 * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * 提示：
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 */
public class Part1024 {
    /**
     * 贪心思想
     * 找小于等于start且end最大的片段，更新剩余片段
     */
    public int videoStitching(int[][] clips, int t) {
        int start = 0, end = 0, count = 0;
        boolean[] used = new boolean[clips.length];
        //外层循环用来控制查找次数，内存循环真实查找更新片段
        for (int i = 0; i < clips.length; i++) {
            int tempEnd = end;
            //找到比start小，且end最大的片段，更新start
            for (int j = 0; j < clips.length; j++) {
                //只要比start小，那么就标记为已使用过，因为这个片段只会选择最长的，较短的后面也用不上
                if (!used[j] && clips[j][0] <= start) {
                    used[j] = true;
                    //如果比当前右边界更大就更新右边界，起始点也更新为右边界
                    if (clips[j][1] >= tempEnd) {
                        tempEnd = clips[j][1];
                        //如果当前右边界已经能覆盖t了，那就不用找了
                        if (tempEnd >= t) {
                            return ++count;
                        }
                    }
                }
            }
            //如果上一轮搜索中右边界变了，说明找到了一个片段，count++
            //如果没变，那就可以提前结束了
            if (tempEnd != end) {
                count++;
            } else {
                return -1;
            }
            start = tempEnd;
            end = tempEnd;
        }
        return -1;
    }
}
