import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static char[][] board;

    private static boolean isCross = true;
    private static int boardFill = 0;
    public static void main(String[] args) {
        initBoard();
        showBoard();
        startGame();
    }
    public static void initBoard() {
        board = new char[][]{{' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
    }
    public static void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static int enterBoardPlace() {
        System.out.println("Enter number from 1 to 9");
        Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
    }
    public static void startGame(){
        do {
            int num = enterBoardPlace();
            if (isCross) {
                switch (num) {
                    case 1:
                        board[0][0] = 'X';
                        break;
                    case 2:
                        board[0][2] = 'X';
                        break;
                    case 3:
                        board[0][4] = 'X';
                        break;
                    case 4:
                        board[2][0] = 'X';
                        break;
                    case 5:
                        board[2][2] = 'X';
                        break;
                    case 6:
                        board[2][4] = 'X';
                        break;
                    case 7:
                        board[4][0] = 'X';
                        break;
                    case 8:
                        board[4][2] = 'X';
                        break;
                    case 9:
                        board[4][4] = 'X';
                        break;
                }
                isCross = false;
                boardFill++;
            } else {
                switch (num) {
                    case 1:
                        board[0][0] = '0';
                        break;
                    case 2:
                        board[0][2] = '0';
                        break;
                    case 3:
                        board[0][4] = '0';
                        break;
                    case 4:
                        board[2][0] = '0';
                        break;
                    case 5:
                        board[2][2] = '0';
                        break;
                    case 6:
                        board[2][4] = '0';
                        break;
                    case 7:
                        board[4][0] = '0';
                        break;
                    case 8:
                        board[4][2] = '0';
                        break;
                    case 9:
                        board[4][4] = '0';
                        break;
                }
                isCross = true;
                boardFill++;
            }
            showBoard();
        } while (boardFill != 9) ;
    }
}