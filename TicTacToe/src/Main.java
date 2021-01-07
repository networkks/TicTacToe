import java.lang.reflect.Method;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        functions f = new functions();
        String turn = "X";

        boolean gameEnded = false;
        for(int i = 0;i < 3;i++){
            System.out.println("[ ][ ][ ]");
        }
        
        do{
            switch(turn){
                case "X":
                    f.input(turn);
                    f.getGrid();
                    gameEnded = f.getWin();
                    if(gameEnded == true){
                        break;
                    }
                    turn = "O";
                    break;
                case "O":
                    f.input(turn);
                    f.getGrid();
                    gameEnded = f.getWin();
                    if(gameEnded == true){
                        break;
                    }
                    turn = "X";
                    break;
            }


        }while(gameEnded == false);
        System.out.println("The game has ended, the winner is: "+turn);
    }
}
