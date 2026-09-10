package com.mycompany.actividad3ed;


public class SudokuSolver {

    public static final int SIZE = 9;


    public boolean solve(int[][] board) {
        int[] emptyCell = findEmptyCell(board);

        if (emptyCell == null) {
            return true; 
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board)) {
                    return true;
                }

                board[row][col] = 0; 
            }
        }

        return false;
    }

    private int[] findEmptyCell(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int boxRow = 3 * (row / 3);
        int boxCol = 3 * (col / 3);
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
