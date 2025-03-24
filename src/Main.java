import java.util.*;

public class Main {
    public static char[][] board;
    private static boolean isCross = true;
    private static int boardFill = 0;
    private static HashSet<Integer> set = new HashSet<>();
    static List<Integer> player1Positions = new ArrayList<>();
    static List<Integer> player2Positions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();
        showBoard();
        startGame(scanner);
    }

    public static void initBoard() {
        board = new char[][]{{' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' }};
    }

    public static void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static int placePiece(Scanner scanner) {
        System.out.println("Enter number from 1 to 9");
        if (scanner.hasNextInt())
            return scanner.nextInt();
        scanner.next();
        return -1;
    }

    public static void startGame(Scanner scanner) {
        int winner = 0;
        do {
            int num = placePiece(scanner);
            if (num < 1 || num > 9) {
                System.out.println("=============================");
                System.out.println("Please enter right number!");
                continue;
            }
            if (istBesetzt(num)) {
                System.out.println("=============================");
                System.out.println("This field is already used");
                System.out.println("=============================");
                showBoard();
                continue;
            }
            char piece;
            if (isCross)
                piece = 'X';
            else piece = '0';
            placePieces(num, piece);
            if (isCross)
                player1Positions.add(num);
            else player2Positions.add(num);
            winner = checkForWinner(player1Positions, player2Positions);
            boardFill++;
            showBoard();
            System.out.println("=============================");
            isCross = !isCross;
        } while (boardFill != 9 && winner == 0);
        if (winner == 1 || winner == 2)
            System.out.println("The winner is Player №" + winner);
        else System.out.println("Its a Draw!");
    }

    public static boolean istBesetzt(int num) {
        if (!set.contains(num)) {
            set.add(num);
            return false;
        } else return true;
    }

    public static int checkForWinner(List<Integer> list1, List<Integer> list2) {
        List<Integer> topRow = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> middleRow = new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }};
        List<Integer> downRow = new ArrayList<>() {{
            add(7);
            add(8);
            add(9);
        }};
        List<Integer> cross1 = new ArrayList<>() {{
            add(1);
            add(5);
            add(9);
        }};
        List<Integer> cross2 = new ArrayList<>() {{
            add(3);
            add(5);
            add(7);
        }};
        List<Integer> column1 = new ArrayList<>() {{
            add(1);
            add(4);
            add(7);
        }};
        List<Integer> column2 = new ArrayList<>() {{
            add(2);
            add(5);
            add(8);
        }};
        List<Integer> column3 = new ArrayList<>() {{
            add(3);
            add(6);
            add(9);
        }};
        List<List> winner = new ArrayList<>();
        Collections.addAll(winner, topRow, middleRow, downRow, cross1, cross2, column1, column2, column3);
        for (List list : winner) {
            if (list1.containsAll(list))
                return 1;
            else if (list2.containsAll(list))
                return 2;
        }
        return 0;
    }
    public static void placePieces(int num, char piece) {
        switch (num) {
            case 1:
                board[0][0] = piece;
                break;
            case 2:
                board[0][2] = piece;
                break;
            case 3:
                board[0][4] = piece;
                break;
            case 4:
                board[2][0] = piece;
                break;
            case 5:
                board[2][2] = piece;
                break;
            case 6:
                board[2][4] = piece;
                break;
            case 7:
                board[4][0] = piece;
                break;
            case 8:
                board[4][2] = piece;
                break;
            case 9:
                board[4][4] = piece;
                break;
        }
    }
}