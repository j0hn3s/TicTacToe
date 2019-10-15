import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        String[] board = {"/", "/", "/", "/", "/", "/", "/", "/", "/"};
        System.out.println("TIC-TAC-TOE");
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Das Feld ist wie folgt aufgebaut und beschriftet: ");
        System.out.println("  0 | 1 | 2  ");
        System.out.println("  ---------  ");
        System.out.println("  3 | 4 | 5  ");
        System.out.println("  ---------  ");
        System.out.println("  6 | 7 | 8  ");
        System.out.println("Welcher Spieler wollen Sie sein(x[0];o[1])?: ");
        String player = eingabe.readLine();
        String com;
        if(player.equals("0")){
            System.out.println("Sie sind Spieler x");
            player = "x";
            com = "o";
        }else if(player.equals("1")) {
            System.out.println("Sie sind Spieler o");
            player = "o";
            com = "x";
        }else{
            System.out.println("Eingabe war falsch. Sie sind nun Player x");
            player = "x";
            com = "o";
        }
        System.out.println("Eingabe des Kreuzes erfolgt durch die Nummer");
        System.out.println("Ausgabe der Computers erfolgt gleich danach");


        for(int round = 1; round <= 5; round++){
            System.out.println("Geben sie ihr "+ player + " ein: ");
            int pos = Integer.parseInt(eingabe.readLine());
            board[pos] = player;
            if(Win.checkwin(board,player)){
                System.out.println("Du hast gegen die Com gewonnen!");
                break;
            }

            board = Win.com(board, player);

            Win.getboard(board);
            if(Win.checkwin(board, com)){
                System.out.println("Com hat gewonnen");
                break;
            }

        }

    }
}
