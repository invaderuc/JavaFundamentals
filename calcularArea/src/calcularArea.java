import java.util.Scanner;

import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Rectangulo;

public class calcularArea {

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
                Circulo circulo = new Circulo();
                area = circulo.calcularArea();
                break;
            case "2":
                Cuadrado cuadrado = new Cuadrado();
                area = cuadrado.calcularArea();
                break;
            case "3":
                Rectangulo rectangulo = new Rectangulo();
                area = rectangulo.calcularArea();
                break;
            default:
                System.out.print("Error");
        }
        if (area > 0)
            System.out.println("El area es " + area);
    }
}
