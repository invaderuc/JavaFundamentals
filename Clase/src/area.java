import java.util.Scanner;
import java.math.MathContext;

public class area {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String respuesta = "";

        System.out.println("Ingrese 1 para calcular el area de un cirulo");
        System.out.println("Ingrese 2 para calcular el area de un Cuadrado");
        System.out.println("Ingrese 3 para calcular el area de un Rectangulo");
        System.out.print("Su opcion: ");

        respuesta = sc.next();
        double area = 0;
        switch (respuesta){
            case "1":
                System.out.print("Ingrese radio del cirulo: ");
                double radio = sc.nextFloat();
                double pi = Math.PI;
                area = pi * radio * radio;
                break;
            case "2":
                System.out.print("Ingrese lado: ");
                double lado = sc.nextFloat();
                area = lado * lado;
                break;
            case "3":
                System.out.print("Ingrese lado 1: ");
                double lado1 = sc.nextFloat();
                System.out.print("Ingrese lado 2: ");
                double lado2 = sc.nextFloat();
                area = lado1 * lado2;
                break;
            default:
                System.out.print("Error");
        }
        if (area > 0)
            System.out.println("El area es " + area);
    }
}
