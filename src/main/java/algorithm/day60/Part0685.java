package algorithm.day60;

/**
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 */
public class Part0685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] unionFindSet = new int[edges.length + 1];
        for (int i = 0; i < unionFindSet.length; i++) {
            unionFindSet[i] = i;
        }
        // wrongEdges[0] 表示环的那组边，[1]和[2]表示某个结点有两个父结点的2组边
        int[][] wrongEdges = new int[3][];
        for (int[] edge : edges) {
            // 正常情况
            if (edge[1] == unionFindSet[edge[1]]) {
                unionFindSet[edge[1]] = edge[0];
                // 一定要判断是否已经存在环了，否则会发生死循环
                if (wrongEdges[0] == null && isCircle(unionFindSet, edge[1])) {
                    wrongEdges[0] = edge;
                }
            } else {
                // 有2个父结点
                wrongEdges[1] = new int[]{unionFindSet[edge[1]], edge[1]};
                wrongEdges[2] = edge;
            }
        }
        // 只有某个结点有2个父结点的情况
        if (wrongEdges[0] == null) {
            return wrongEdges[2];
        }
        // 只有环的情况
        if (wrongEdges[1] == null) {
            return wrongEdges[0];
        }

        // 2种情况都有，这个时候我们需要判断某个结点的哪个父结点在环中，在环中的就是返回的答案
        if (isCircle(unionFindSet, wrongEdges[1][0])) {
            return wrongEdges[1];
        }
        return wrongEdges[2];
    }

    private boolean isCircle(int[] unionFindSet, int node) {
        int boss = node;
        while (unionFindSet[boss] != boss) {
            if (node == unionFindSet[boss]) {
                return true;
            }
            boss = unionFindSet[boss];
        }
        return false;
    }
}
