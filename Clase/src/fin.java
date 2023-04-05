import java.util.Scanner;

public class fin {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String esFin = "";

        while (!esFin.equalsIgnoreCase("fin") ){
            System.out.print("Ingrese una palabra: ");
            esFin = sc.next();
            System.out.println(esFin);
        }

        System.out.print("Gracias");
    }
}
