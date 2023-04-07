package figuras;

import figuras.IDFigura;

import java.util.Scanner;

public class Cuadrado implements IDFigura {

    double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calcularArea(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese lado: ");
        setLado(sc.nextDouble());

        return this.lado*this.lado;
    }
}
