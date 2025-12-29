package leetcode.meta;

import java.util.Scanner;
// 419: https://leetcode.com/problems/battleships-in-a-board/
public class BattlshipsInBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int m = sc.nextInt();

        System.out.println("Enter number of columns:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        char[][] board = new char[m][n];

        System.out.println("Enter the board row by row (use X for ship, . for water):");
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine().trim();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int result = countBattleships(board);
        System.out.println("Number of battleships: " + result);
    }

    private static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != 'X') continue;

                // If there's an 'X' above or left, it's part of an existing ship
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;

                // Otherwise, it's the start of a new ship
                count++;
            }
        }

        return count;
    }


}
