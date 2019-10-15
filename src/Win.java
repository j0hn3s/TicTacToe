public class Win {
    public static boolean checkwin(String[] board, String player) {
        if(board[0].equals(player)&&board[1].equals(player)&&board[2].equals(player)){
            return true;
        }else if(board[3].equals(player) && board[4].equals(player) &&board[5].equals(player)){
            return true;
        }else if(board[6].equals(player)&&board[7].equals(player)&&board[8].equals(player)){
            return true;
        }else if(board[0].equals(player)&&board[3].equals(player)&&board[6].equals(player)){
            return true;
        }else if(board[1].equals(player)&&board[4].equals(player)&&board[7].equals(player)){
            return true;
        }else if(board[2].equals(player)&&board[5].equals(player)&&board[8].equals(player)){
            return true;
        }else if(board[0].equals(player)&&board[4].equals(player)&&board[8].equals(player)){
            return true;
        }else if(board[2].equals(player)&&board[4].equals(player)&&board[6].equals(player)){
            return true;
        }else
            return false;
    }

    public static boolean checkfreespace(String[] board, int pos){
        return !(board[pos].equalsIgnoreCase("x") || board[pos].equalsIgnoreCase("o"));
    }

    public static int getRandomDoubleBetweenRange(double min, double max){

        int x = (int)((Math.random()*((max-min)+1))+min);

        return x;

    }

    public static String[] copyboard(String[] board){
        return board.clone();
    }

    public static String[] com(String[] board, String player){
        String com;
        if(player.equals("o")){
            com = "x";
        }else
            com = "o";

        for(int i = 0; i<=8; i++){
            String[] boardcopied = copyboard(board);
            if(checkfreespace(boardcopied, i)){
                boardcopied[i]=player;
                if(checkwin(boardcopied, player)) {
                    boardcopied[i] = com;
                    return boardcopied;
                }
            }
        }
        for(int i = 0; i<=20; i++){
            int r = getRandomDoubleBetweenRange(0, 8);
            if(checkfreespace(board, r)){
                String[] n = copyboard(board);
                n[r] = com;
                return n;
            }
        }
        return copyboard(board);
    }

    public static void getboard(String[] board){
        for(int i = 0; i <= 6; i = i + 3){
            for(int h = 0; h <= 2; h++){
                System.out.print(board[i+h] + " ");
            }
            System.out.println("");
        }
    }

}
