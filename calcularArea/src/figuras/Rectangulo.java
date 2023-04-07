package figuras;
import java.util.Scanner;

public class Rectangulo implements IDFigura {

    double lado1;
    double lado2;

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double calcularArea(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese lado 1: ");
        setLado1(sc.nextDouble());

        System.out.print("Ingrese lado 2: ");
        setLado2(sc.nextDouble());

        return this.lado1*this.lado2;
    }
}
