import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        Scanner teclado = new Scanner( System.in );

        System.out.println("Lista de Exercícios: ");
        System.out.println("1 - Média Aritimética\n2 - Par ou Ímpar\n3 - Menor valor\n4 - Função Matemática\n5 - Função Matemática 2\n6 - Equação de Segundo Grau");
        System.out.print("Digite qual exercício você deseja: ");
        int ex = teclado.nextInt();

        switch (ex) {
            case 1: // Média Aritimética
                System.out.print("Digite quantos valores serão adicionados: ");
                int n = teclado.nextInt();

                if (n < 3 || n > 5) System.out.println("Valor tem que ser maior que 3 e menor que 5.");
                else {
                    int soma = 0;
                    int result = 0;

                    for (int i = 0; i < n; i++){
                        System.out.print("Digite o " + (i+1) + "° valor: ");
                        int aux = teclado.nextInt();
                        soma = soma + aux;
                    }

                    result = soma / n;
                    System.out.println("A média dos valores é " + result);
                }
                break;

            case 2: // Par ou ímpar
                System.out.print("Digite um valor: ");
                int x = teclado.nextInt();

                if((x%2) == 0) System.out.println("Valor é par.");
                else System.out.println("Valor é impar.");
                break;

            case 3: // Menor valor
                System.out.println("Digite o primeiro valor: ");
                int a = teclado.nextInt();
                System.out.println("Digite o segundo valor: ");
                int b = teclado.nextInt();
                System.out.println("Digite o terceiro valor: ");
                int c = teclado.nextInt();
                int menor = Math.min(Math.min(a, b), c);
                System.out.println("O menor valor é " + menor);
                break;

            case 4: // Funcao Matematica
                System.out.print("Digite um valor para x: ");
                double valor = teclado.nextDouble();

                if(valor <= 4) System.out.println("Valor tem que ser maior que 4.");
                else {
                    double y = Math.sin(valor) / Math.sqrt(valor-4);
                    System.out.println("O resultado é " + y);
                }
                break;

            case 5: // Funcao Matematica 2
                System.out.print("Digite um valor para x: ");
                double w = teclado.nextFloat();

                if(w == 0 || w == 4) System.out.println("X não pode ter esse valor.");
                else {
                    double y = Math.sqrt(w) / (w-4);
                    System.out.println("O valor é " + y);
                }
                break;

            case 6: // Equação de Segundo Grau
                System.out.print("Digite o coeficiente a: ");
                double ca = teclado.nextDouble();
                System.out.print("Digite o coeficiente b: ");
                double cb = teclado.nextDouble();
                System.out.print("Digite o coeficiente c: ");
                double cc = teclado.nextDouble();

                double delta = Math.pow(cb, 2) - 4 * ca * cc;

                if (delta < 0) System.out.println("Não existe raiz real.");
                else {
                    if (delta == 0) {
                        System.out.println("Existe somente uma raiz real");
                        double r1 = -cb / (2*ca);
                        System.out.println(r1);
                    } else {
                        System.out.println("Delta: " + delta);
                        System.out.println("Existem duas raizes");
                        double r1 = (-cb + Math.sqrt(delta)) / (2*ca);
                        double r2 = (-cb - Math.sqrt(delta)) / (2*ca);
                        System.out.println("Primeira raiz: " + r1);
                        System.out.println("Segunda raiz: " + r2);
                    }
                }
                break;
        }
    }
}