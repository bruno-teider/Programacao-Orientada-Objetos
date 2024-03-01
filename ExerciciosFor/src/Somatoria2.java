import java.util.Scanner;
import java.lang.Math;

public class Somatoria2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de valors: ");
        double n = scanner.nextDouble();
        double soma = 0;
        double pi = 3.14;

        for(int i = 1; i <= n; i++){
            System.out.print("Digite um valor para x: ");
            double x = scanner.nextDouble();
            soma = soma + ((Math.pow(x, 2) / (pi - i)));
        }
        System.out.println("O resultado da soma foi " + soma);
    }
}
