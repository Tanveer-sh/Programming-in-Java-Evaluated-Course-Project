import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class TicTacToe {
    private static char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome to Digital Tic-Tac-Toe ---");

        while (true) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()) - 1;
                if (choice < 0 || choice > 8 || board[choice] == 'X' || board[choice] == 'O') {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number between 1 and 9.");
                continue;
            }

            board[choice] = currentPlayer;

            if (checkWinner()) {
                printBoard();
                System.out.println("Congratulations! Player " + currentPlayer + " wins!");
                saveResult("Player " + currentPlayer + " Won");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                saveResult("Draw");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private static boolean checkWinner() {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Cols
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };
        for (int[] condition : winConditions) {
            if (board[condition[0]] == board[condition[1]] && board[condition[1]] == board[condition[2]]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (char c : board) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }

    private static void saveResult(String result) {
        try (FileWriter writer = new FileWriter("game_history.txt", true)) {
            writer.write("Match Result: " + result + " | Timestamp: " + new java.util.Date() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving history.");
        }
    }
}
