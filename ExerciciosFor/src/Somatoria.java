import java.util.Scanner;
import java.lang.Math;

public class Somatoria {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double pi = 3.14;
        double soma = 0;

        System.out.print("Digite a quantidade de valors: ");
        double n = scanner.nextDouble();

        for(double i = 1; i <= n; i++){
            System.out.print("Digite algum valor para x: ");
            double x = scanner.nextDouble();

            double t = Math.pow((pi - x), 2) / i;
            soma = soma + t;
        }
        System.out.println("Valor da somatória é " + soma);
    }
}
