import java.util.Scanner;

public class Circulo implements IDFigura{

    public static final double pi = 3.1415;

    double radio;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularArea(){
        System.out.print("Ingrese Radio: ");
        Scanner sc = new Scanner(System.in);
        setRadio(sc.nextDouble());

        return this.radio*this.radio*pi;
    }
}
