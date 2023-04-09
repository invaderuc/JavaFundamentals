import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import Element.Box;

public class Game {

    public static void main(String[] args){

        final int SIZEMATRIX = 5;
        String reset = "";
        //START GAME
        while(!reset.toLowerCase(Locale.ROOT).equals("x")) {
            //SET BOARD
            String[][] board = new String[SIZEMATRIX][SIZEMATRIX];
            String[][] playerBoard = new String[SIZEMATRIX][SIZEMATRIX];
            Integer bombNumber = 0;

            //GENERATE MATRIX
            for(Integer i = 0; i < SIZEMATRIX; i++){
                for(Integer j = 0; j < SIZEMATRIX; j++) {
                    board[i][j] = "[O]";
                    playerBoard[i][j] = "[0]";
                }
            }
            //SELECT LEVEL
            while(bombNumber == 0){
                bombNumber = selectLevel();
            }
            //GENERATE CORDINATES FOR BOMBS
            Integer allBombs[][] = generateCordinates(SIZEMATRIX,bombNumber);

            //PLANT BOMBS
            board = addBombs(board,allBombs);

            play(allBombs, playerBoard, board);
            System.out.print("Ingrese x para salir: ");
            Scanner sc = new Scanner(System.in);
            reset = sc.next();
        }
    }

    /*FUNCTION FOR LEVEL SELECTION*/
    public static Integer selectLevel(){

        final int BOMBNUMBEREASY = 10;
        final int BOMBNUMBERMEDIUM = 12;
        final int BOMBNUMBERHARD = 14;

        System.out.println("Selecione su nivel: ");
        System.out.println("    1.- Facil ("+BOMBNUMBEREASY+" Bombas)");
        System.out.println("    2.- Medio ("+BOMBNUMBERMEDIUM+" Bombas)");
        System.out.println("    3.- Dificil ("+BOMBNUMBERHARD+" Bombas)");
        System.out.print("Su opcion: ");

        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        respuesta = sc.next();

        Integer bombNumber = 0;
        switch (respuesta.toLowerCase(Locale.ROOT)){
            case "facil":
                bombNumber = BOMBNUMBEREASY;
                break;
            case "medio":
                bombNumber = BOMBNUMBERMEDIUM;
                break;
            case "dificil":
                bombNumber = BOMBNUMBERHARD;
                break;
            default:
                System.out.print("Error");
        }
        return bombNumber;
    }

    /*GENERATE CORDINATES FOR BOMBS*/
    public static Integer[][] generateCordinates(Integer size, Integer amount){

        //ARRAY FOR BOMBS
        Integer[][] allBombs = new Integer[amount][2];
        // DECLARE RANDOM
        Random random = new Random();
        //CONTROL TO AVOID PLANT BOMB IN THE SAME PLACE
        Boolean exist = false;
        //FLAGS AMOUNT OF BOMBS
        Integer bombs = 0;

        while(bombs < amount) {

            // GENERATE RANDOM
            int randomNumber1 = random.nextInt(0, size);
            int randomNumber2 = random.nextInt(0, size);

            // DECLARE BOX
            Box box = new Box(randomNumber1,randomNumber2);

            //LOOKS FOR A BOMB IN THE SAME PLACE
            exist = box.lookFor(allBombs);

            if(!exist){
                allBombs[bombs][0] = box.getCoordinateX();
                allBombs[bombs][1] = box.getCoordinateY();
                bombs++;
            }
        }
        return allBombs;
    }

    /*ADD BOMB TO BOARD*/
    public static String[][] addBombs(String [][] board, Integer [][] allBombs){

        Integer x,y = 0;

        for(Integer i = 0; i < allBombs.length; i++){

            x = allBombs[i][0];
            y = allBombs[i][1];
            board [x][y] = "[X]";
        }
        return board;
    }

    /*PRINT BOARD*/
    public static void showStringMatrix(String [][] matrix){
        for(Integer i = 0; i < matrix.length; i++){
            for (Integer j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /*GAME CODE*/
    public static void play(Integer [][] allBombs, String [][] playerBoard,String [][] board ){

        final int TRYSTOWIN = 6;

        Scanner sc = new Scanner(System.in);
        Integer playerCordenateX = -1;
        Integer playerCordenateY = -1;

        Integer[][] allTrys = new Integer[TRYSTOWIN][2];

        Integer trys = 0;
        Boolean exist = false;
        Boolean samePlace = false;
        while(trys < 6){

            playerCordenateX = -1;
            playerCordenateY = -1;
            while(playerCordenateX < 0 || playerCordenateX >= board.length){
                System.out.print("Ingrese coordenada X: ");
                playerCordenateX = sc.nextInt();
            }
            while(playerCordenateY < 0 || playerCordenateY >= board.length){
                System.out.print("Ingrese coordenada Y: ");
                playerCordenateY = sc.nextInt();
            }

            Box box = new Box(playerCordenateX,playerCordenateY);
            //LOOKS FOR A BOMB IN THE SAME PLACE
            exist = box.lookFor(allBombs);

            //LOOKS IF PLAYER TRY IN THE SAME PLACE TWICE
            samePlace = box.lookFor(allTrys);
            allTrys[trys][0] = playerCordenateX;
            allTrys[trys][1] = playerCordenateY;

            if(samePlace){
                System.out.println("Ya habias probado aca");
            }else if(exist){
                break;
            }else{
                playerBoard[playerCordenateX][playerCordenateY] = "[ ]";
                showStringMatrix(playerBoard);
                trys++;
                System.out.println("Fantastico llevas "+trys+" intentos!");
            }
        }

        if(trys >= 6){
            System.out.println("FELICIADADES GANASTE EL JEUGO");
        }else{
            System.out.println("QUE LASTIMA!! HAS EXPLOTADO");
            //SHOW BOARD
            showStringMatrix(board);
        }
    }
}