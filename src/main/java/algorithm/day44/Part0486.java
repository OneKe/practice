package algorithm.day44;

/**
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * 提示：
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于 10000000 。
 * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 */
public class Part0486 {
    /**
     * 【博弈】【动态规划】
     * 区间[i, j]中先手可获得的最大值：掌握主动权———拿[端点]+[剩下的后手]。拿左端点还是右端点自己决定(取最大值)
     * 区间[i, j]中后手可获得的最大值：身不由己———不到端点，且只能拿到[剩下的先手]。因为只能用对手剩下的，所以只能取[剩下先手]的最小值
     * <p>
     * 注意：
     * 1.【博弈】的题目中，先手和后手在动态规划的过程中不断巧妙转化，注意体会
     * 2.【博弈】的题目中，先手主动，后手被动———后手倾向于【被动记录】而非【主动选择】，这是博弈题目的默认要求
     * 3.【动态规划】时：注意填表顺序；数组可以压缩，但没必要
     */
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if ((len & 1) == 0) {
            return true;
        }
        int[][] dp1 = new int[len][len];    // 先手
        int[][] dp2 = new int[len][len];    // 后手
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    dp1[i][j] = nums[i];    // 初始化
                    continue;
                }
                dp1[i][j] = Math.max(nums[i] + dp2[i + 1][j], nums[j] + dp2[i][j - 1]);     //【主动选择】
                dp2[i][j] = Math.min(dp1[i + 1][j], dp1[i][j - 1]);                         //【被动记录】
            }
        }
        return dp1[0][len - 1] >= dp2[0][len - 1];
    }
}