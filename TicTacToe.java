import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (checkRowCol(board[0][0], board[1][1], board[2][2]) ||
                checkRowCol(board[0][2], board[1][1], board[2][0]));
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return (c1 != '-') && (c1 == c2) && (c2 == c3);
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean placeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public void playGame(Scanner scanner) {
        System.out.println("Enter row and column numbers (0-2) separated by space:");

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn:");

            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (placeMove(row, col)) {
                    if (checkForWin()) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isBoardFull()) {
                        printBoard();
                        System.out.println("It's a tie!");
                        break;
                    } else {
                        changePlayer();
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers between 0-2.");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");

        while (true) {
            TicTacToe game = new TicTacToe();
            game.playGame(scanner);

            System.out.print("\nPlay again? (y/n): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("y")) {
                break;
            }
            System.out.println();
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
