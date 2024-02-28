import java.util.Scanner;
import java.lang.Math;

public class Switch {
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Exercícios: \n1 - Operações Matematicas \n2 - Aleatorio Cores");
        System.out.print("Digite o exercício que deseja: ");
        int ex = teclado.nextInt();

        if(ex == 1){
            // Exercício 1 - Operações Matematicas
            System.out.print("Digite o primeiro valor: ");
            float x = teclado.nextFloat();
            System.out.print("Digite o segundo valor: ");
            float y = teclado.nextFloat();

            // Interface ao usuario
            System.out.println("O primeiro valor digitado foi " + x + "O segundo valor digitado foi: " + y);
            System.out.println("Operações Disponiveis: \n 1. Adição\n 2. Subtração\n 3.Multiplicação\n 4. Divisão");
            System.out.print("Digite a sua escolha: ");
            int op = teclado.nextInt();
            float result = 0;

            switch (op) {
                case 1: result = (x + y);break;
                case 2: result = (x - y);break;
                case 3: result = (x * y);break;
                case 4: result = (x / y);break;
            }
            System.out.print("Resultado: " + result);
        }
        else if (ex == 2) {
            // Exercício 2 - Aleatorio Cores
            int min = 0;
            int max = 9;
            int random = (int)Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println("O número gerado foi " + random);

            switch (random){
                case (0): case(1): case(2): System.out.println("Azul"); break;
                case (5): case(7): case(9): System.out.println("Marrom"); break;
                default: System.out.println("Amarelo");
            }
        }
        else System.out.println("Valor inválido");
    }
}
