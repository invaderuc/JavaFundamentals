import java.util.Scanner;

public class suma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad, suma = 0;

        System.out.print("Ingrese la cantidad de números a sumar: ");
        cantidad = sc.nextInt();

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            suma += sc.nextInt();
        }

        System.out.println("El resultado de la suma es: " + suma);
    }
}