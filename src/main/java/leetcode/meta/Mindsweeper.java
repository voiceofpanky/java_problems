package leetcode.meta;

import java.util.*;

public class Mindsweeper {

    static int[][] dirs = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] board = new char[rows][cols];

        System.out.println("Enter board (characters M/E):");
        for (int i = 0; i < rows; i++) {
            String line = sc.next();
            for (int j = 0; j < cols; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        System.out.println("Enter click row and column:");
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] updated = updateBoard(board, new int[]{r, c});

        System.out.println("\nUpdated Board:");
        printBoard(updated);
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);
        return board;
    }

    private static void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return;

        if (board[r][c] != 'E')
            return;

        int mines = countMines(board, r, c);

        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
            return;
        }

        board[r][c] = 'B';

        for (int[] d : dirs) {
            dfs(board, r + d[0], c + d[1]);
        }
    }

    private static int countMines(char[][] board, int r, int c) {
        int count = 0;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length)
                continue;

            if (board[nr][nc] == 'M')
                count++;
        }

        return count;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}