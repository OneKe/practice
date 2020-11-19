package algorithm.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Part0079 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(i, j, 0, word, visited, board)) return true;
            }
        }
        return false;

    }

    private boolean backtrack(int i, int j, int count, String word, boolean[][] visited, char[][] board) {
        if (count == word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(count) || visited[i][j])
            return false;
        visited[i][j] = true;
        if (backtrack(i + 1, j, count + 1, word, visited, board)
                || backtrack(i - 1, j, count + 1, word, visited, board)
                || backtrack(i, j + 1, count + 1, word, visited, board)
                || backtrack(i, j - 1, count + 1, word, visited, board))
            return true;
        visited[i][j] = false; // 回溯
        return false;
    }
}
