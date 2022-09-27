import java.util.Scanner;

public class Main {

    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard("White");

        board.board[0][0] = new Rook("White");

        board.board[0][4] = new King("White");

        board.board[0][7] = new Rook("White");
        board.board[1][0] = new Pawn("White");
        board.board[1][1] = new Pawn("White");
        board.board[1][2] = new Pawn("White");
        board.board[1][3] = new Pawn("White");
        board.board[1][4] = new Pawn("White");
        board.board[1][5] = new Pawn("White");
        board.board[1][6] = new Pawn("White");
        board.board[1][7] = new Pawn("White");

        board.board[7][0] = new Rook("Black");

        board.board[7][4] = new King("Black");

        board.board[7][7] = new Rook("Black");
        board.board[6][0] = new Pawn("Black");
        board.board[6][1] = new Pawn("Black");
        board.board[6][2] = new Pawn("Black");
        board.board[6][3] = new Pawn("Black");
        board.board[6][4] = new Pawn("Black");
        board.board[6][5] = new Pawn("Black");
        board.board[6][6] = new Pawn("Black");
        board.board[6][7] = new Pawn("Black");
        return board;
    }

    public static void main(String[] args) {

        ChessBoard board = buildBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
               ����� ��������� ���� ���� ������� �������:
               'exit' - ��� ������
               'replay' - ��� ����������� ����
               'castling0' ��� 'castling7' - ��� ��������� �� ��������������� �����
               'move 1 1 2 3' - ��� ������������ ������ � ������� 1 1 �� 2 3(���� ��� ��������� ������ �� 0 �� 7)
               ��������� ����� �� ������ ������ ���� ������ �����, ��������� �� ������� ���� �����, ����� �� ��������� ��� � ������� ���������?""");
        System.out.println();
        board.printBoard();
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            else if (s.equals("replay")) {
                System.out.println("������");
                board = buildBoard();
                board.printBoard();
            } else {
                if (s.equals("castling0")) {
                    if (board.castling0()) {
                        System.out.println("��������� �������");
                        board.printBoard();
                    } else {
                        System.out.println("��������� �� �������");
                    }
                } else if (s.equals("castling7")) {
                    if (board.castling7()) {
                        System.out.println("��������� �������");
                        board.printBoard();
                    } else {
                        System.out.println("��������� �� �������");
                    }
                } else if (s.contains("move")) {
                    String[] a = s.split(" ");
                    try {
                        int line = Integer.parseInt(a[1]);
                        int column = Integer.parseInt(a[2]);
                        int toLine = Integer.parseInt(a[3]);
                        int toColumn = Integer.parseInt(a[4]);
                        if (board.moveToPosition(line, column, toLine, toColumn)) {
                            System.out.println("������� �������������");
                            board.printBoard();
                        } else System.out.println("������������ �� �������");
                    } catch (Exception e) {
                        System.out.println("�� ���-�� ����� �� ���, ���������� ��� ���");
                    }

                }
            }
        }
    }
}