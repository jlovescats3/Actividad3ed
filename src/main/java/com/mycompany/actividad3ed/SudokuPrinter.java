package com.mycompany.actividad3ed;

public class SudokuPrinter {

    private static final int SIZE = SudokuSolver.SIZE;

    public void print(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < SIZE; c++) {
                sb.append(board[r][c]);
                if ((c + 1) % 3 == 0 && c != SIZE - 1) {
                    sb.append(" | ");
                } else if (c != SIZE - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            if ((r + 1) % 3 == 0 && r != SIZE - 1) {
                System.out.println("------+-------+------");
            }
        }
    }
}
