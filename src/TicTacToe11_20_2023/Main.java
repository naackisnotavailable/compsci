package TicTacToe11_20_2023;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] board = {".",".",".",".",".",".",".",".","."};
        int turn = 0;
        int pos;
        while(true) {
            turn+=1;
            printBoard(board);
            if(turn%2==0){
                System.out.println("it is x turn.");
                while(true){
                    System.out.print("Enter a board position: ");
                    pos = scanner.nextInt();
                    if(Objects.equals(board[pos], ".")&& pos<=8 && pos>=0) {
                        board[pos] = "x";
                        break;
                    }else{
                        System.out.println("try again");
                    }
                }
            }else{
                System.out.println("it is o turn.");
                while(true){
                    System.out.print("Enter a board position: ");
                    pos = scanner.nextInt();
                    if(Objects.equals(board[pos], ".")) {
                        board[pos] = "o";
                        break;
                    }
                }
            }
            if(Objects.equals(checkWin(board), "x")){
                System.out.println("x wins");
                System.out.println("Play again? (y/n)");
                String scan = scanner.next();
                if(Objects.equals(scan, "y")){
                    turn=0;
                    board = new String[]{".", ".", ".", ".", ".", ".", ".", ".", "."};
                    continue;
                }
                break;
            }else if(Objects.equals(checkWin(board), "o")){
                System.out.println("o wins");
                System.out.println("Play again? (y/n)");
                String scan = scanner.next();
                if(Objects.equals(scan, "y")){
                    turn=0;
                    board = new String[]{".", ".", ".", ".", ".", ".", ".", ".", "."};
                    continue;

                }
                break;

            }
            boolean full = true;
            for(String x: board){
                if (x.equals(".")) {
                    full = false;
                    break;
                }
            }
            if(full){
                System.out.println("tie");
                System.out.println("Play again? (y/n)");
                String scan = scanner.next();
                if(Objects.equals(scan, "y")){
                    turn=0;
                    board = new String[]{".", ".", ".", ".", ".", ".", ".", ".", "."};
                    continue;
                }
                break;

            }
        }
    }
    public static void printBoard(String[] board){
        System.out.print(board[0]);
        System.out.print(board[1]);
        System.out.println(board[2]);
        System.out.print(board[3]);
        System.out.print(board[4]);
        System.out.println(board[5]);
        System.out.print(board[6]);
        System.out.print(board[7]);
        System.out.println(board[8]);


    }

    public static String checkWin(String[] board){
        if(Objects.equals(board[0], "o")&&Objects.equals(board[1], "o")&&Objects.equals(board[2], "o")) {
            return "o";
        }
        if(Objects.equals(board[0], "x")&&Objects.equals(board[1], "x")&&Objects.equals(board[2], "x")) {
            return "x";
        }
        if(Objects.equals(board[3], "o")&&Objects.equals(board[4], "o")&&Objects.equals(board[5], "o")) {
            return "o";
        }
        if(Objects.equals(board[3], "x")&&Objects.equals(board[4], "x")&&Objects.equals(board[5], "x")) {
            return "x";
        }
        if(Objects.equals(board[6], "o")&&Objects.equals(board[7], "o")&&Objects.equals(board[8], "o")) {
            return "o";
        }
        if(Objects.equals(board[6], "x")&&Objects.equals(board[7], "x")&&Objects.equals(board[8], "x")) {
            return "x";
        }
        if(Objects.equals(board[0], "o")&&Objects.equals(board[3], "o")&&Objects.equals(board[6], "o")) {
            return "o";
        }
        if(Objects.equals(board[0], "x")&&Objects.equals(board[3], "x")&&Objects.equals(board[6], "x")) {
            return "x";
        }
        if(Objects.equals(board[1], "o")&&Objects.equals(board[4], "o")&&Objects.equals(board[7], "o")) {
            return "o";
        }
        if(Objects.equals(board[1], "x")&&Objects.equals(board[4], "x")&&Objects.equals(board[7], "x")) {
            return "x";
        }
        if(Objects.equals(board[2], "o")&&Objects.equals(board[5], "o")&&Objects.equals(board[8], "o")) {
            return "o";
        }
        if(Objects.equals(board[2], "x")&&Objects.equals(board[5], "x")&&Objects.equals(board[8], "x")) {
            return "x";
        }
        if(Objects.equals(board[0], "o")&&Objects.equals(board[4], "o")&&Objects.equals(board[8], "o")) {
            return "o";
        }
        if(Objects.equals(board[0], "x")&&Objects.equals(board[4], "x")&&Objects.equals(board[8], "x")) {
            return "x";
        }
        if(Objects.equals(board[2], "o")&&Objects.equals(board[4], "o")&&Objects.equals(board[6], "o")) {
            return "o";
        }
        if(Objects.equals(board[2], "x")&&Objects.equals(board[4], "x")&&Objects.equals(board[6], "x")) {
            return "x";
        }
        return null;
    }
}