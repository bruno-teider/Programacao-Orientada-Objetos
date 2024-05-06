import java.util.Scanner;
import java.lang.Math;

public class Integral {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Digite o valor de b: ");
        double b = scanner.nextDouble();

        if(a <= b){
            System.out.print("Digite o valor de n: ");
            double n = scanner.nextDouble();
            if(n > 0){
                double area_total = 0;
                double x = a;
                double h = (b - a) / n;
                double y1 = (2 * Math.sin(x)) + (Math.cos(x) / 3);

                int i = 0;
                while(i < n){
                    x = x + h;
                    double y2 = (2 * Math.sin(x)) + (Math.cos(x) / 3);
                    double area_trapezio = ((y1+y2) / 2) * h;
                    area_total = area_total + area_trapezio;
                    y1 = y2;
                    i++;
                }
                System.out.println("Área total: "+ area_total);
            } else System.out.println("Valor de n deve ser maior do que zero");
        } else System.out.println("Valor de A deve ser menor ou igual ao valor de B");
    }
}
