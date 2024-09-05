package Project1;

import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int moves = 0;

        printBoard();

        while (!gameWon && moves < 9) {
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-3 for each): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                moves++;
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else if (moves == 9) {
                    System.out.println("The game is a tie!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
        scanner.close();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
            System.out.println("-------------");
        }
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }
}
