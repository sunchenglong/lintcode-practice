package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsSolver(board, used, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }


    private boolean dfsSolver(char[][] board, boolean[][] used, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        } else if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
            if (!used[x][y] && board[x][y] == word.charAt(index)) {
                used[x][y] = true;
                if (dfsSolver(board, used, word, index + 1, x + 1, y) ||
                        dfsSolver(board, used, word, index + 1, x - 1, y) ||
                        dfsSolver(board, used, word, index + 1, x, y + 1) ||
                        dfsSolver(board, used, word, index + 1, x, y - 1)) {
                    return true;
                }
                used[x][y] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch79().exist(new char[][]{new char[]{'a', 'b'}}, "ba"));
    }
}
