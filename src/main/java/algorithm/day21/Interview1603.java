package algorithm.day21;

/**
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * <p>
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 */
public class Interview1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //保证 a2的横坐标都大于等于a1，如果横坐标相等，则纵坐标大于，方便重合判定
        if (start1[0] > end1[0] || (start1[0] == end1[0]) && start1[1] > end1[1]) {
            int[] tmp = end1;
            end1 = start1;
            start1 = tmp;
        }
        if (start2[0] > end2[0] || (start2[0] == end2[0]) && start2[1] > end2[1]) {
            int[] tmp = end2;
            end2 = start2;
            start2 = tmp;
        }
        //c=start2-start1  a=end1-start1 b=end2-start2
        int[] c = new int[]{(start2[0] - start1[0]), (start2[1] - start1[1])};
        int[] a = new int[]{(end1[0] - start1[0]), (end1[1] - start1[1])};
        int[] b = new int[]{(end2[0] - start2[0]), (end2[1] - start2[1])};
        //计算 a×b  c×a c×b
        int a_b = multiCross(a, b);
        int c_a = multiCross(c, a);
        int c_b = multiCross(c, b);
        //这里要强转double，不然计算有错误
        double t = (double) c_b / a_b;
        double u = (double) c_a / a_b;
        //判断是否平行，且再同一直线上
        if (c_a == 0 && a_b == 0) {
            //判断是否平行于y轴，平行则比较纵坐标
            if (start1[0] == end1[0]) {
                if ((end1[1] <= end2[1] && end1[1] >= start2[1]) || (end2[1] <= end1[1] && end2[1] >= start1[1])) {
                    if (start1[1] > start2[1]) return new double[]{start1[0], start1[1]};
                    else return new double[]{start2[0], start2[1]};
                } else return new double[]{};
            } else {   //不平行y轴比较横坐标
                if ((end1[0] <= end2[0] && end1[0] >= start2[0]) || (end2[0] <= end1[0] && end2[0] >= start1[0])) {
                    if (start1[0] > start2[0]) return new double[]{start1[0], start1[1]};
                    else return new double[]{start2[0], start2[1]};
                } else return new double[]{};
            }
        }
        //平行且不相交
        if (c_a != 0 && a_b == 0) return new double[]{};
        //不平行比较 t,u是否在[0,1]内
        if ((0 <= t && t <= 1) && (0 <= u && u <= 1)) {
            return new double[]{(start1[0] + t * a[0]), (start1[1] + t * a[1])};
        }
        return new double[]{};
    }

    //叉乘
    public int multiCross(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }
}
