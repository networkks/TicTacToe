import java.util.Arrays;
import java.util.Scanner;

public class functions {
    Scanner scan = new Scanner(System.in);
    private String[] firstLine = new String[3];
    private String[] secondLine = new String[3];
    private String[] thirdLine = new String[3];

    private int inputRow;
    private int inputCol;

    private String[][] grid = {firstLine, secondLine, thirdLine};

    public void input(String turn){
        boolean retry = false;
        System.out.println("Turn: "+turn);
        System.out.print("Enter column number [1,2,3]: ");
        inputCol = scan.nextInt();
        System.out.println(" ");
        System.out.print("Enter row number [1,2,3]: ");
        inputRow = scan.nextInt();
        System.out.println(" ");
        if(canSetSpace(inputCol-1, inputRow-1, turn)){
            setSpace(inputCol-1, inputRow-1, turn);
        }else{
            retry = true;
            do{
                System.out.println("Retry: "+turn);
                System.out.print("Enter column number [1,2,3]: ");
                inputCol = scan.nextInt();
                System.out.println(" ");
                System.out.print("Enter row number [1,2,3]: ");
                inputRow = scan.nextInt();
                System.out.println(" ");
                if(canSetSpace(inputCol-1, inputRow-1, turn)){
                    setSpace(inputCol-1, inputRow-1, turn);
                    retry = false;
                    break;
                }
            }while(retry == true);
        }
    }

    public boolean canSetSpace(int col, int row, String turn){
        boolean canSet = false;
        switch(turn){
            case "X":
            if(grid[col][row] != "O" && grid[col][row] == null){
                canSet = true;
            }
            break;
            case "O":
            if(grid[col][row] != "X" && grid[col][row] == null){
                canSet = true;
            }
            break;
        }
        return canSet;
    }
    public void setSpace(int col, int row, String XorO){
        grid[col][row] = XorO; 
    }
    public void getGrid(){
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(grid[i][j] == null){
                    System.out.print("[ ]");
                }else{
                    System.out.print("["+grid[i][j]+"]");
                }
            }
            System.out.println(" ");
        }
    }

    public Boolean getWin(){
        Boolean win = false;
        for(int v = 0;v<3;v++){
            if(win == true){
                break;
            }
            if(grid[v][0] == grid[v][1] && grid[v][0] == grid[v][2] && grid[v][0] != null && grid[v][1] != null && grid[v][2] != null){
                win = true;
            }
            if(grid[0][v] == grid[1][v] && grid[0][v] == grid[2][v] && grid[0][v] != null && grid[1][v] != null && grid[2][v] != null){
                win = true;
            }
        }
        if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != null && grid[1][1] != null && grid[2][2] != null){
            win = true;
        }
        if(grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0] && grid[0][2] != null && grid[1][1] != null && grid[2][0] != null){
        win = true;
        }
        return win;
    }
}
