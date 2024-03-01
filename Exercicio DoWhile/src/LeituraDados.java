import java.util.Scanner;

public class LeituraDados {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("1 - Vezes Indeterminadas \n2 - Vezes Definidas \nQual sua opção: ");
        int x = scanner.nextInt();

        if(x == 1){
            int n = 0;
            do{
                System.out.print("Digite um valor entre 5 e 10: ");
                n = scanner.nextInt();
            } while(n >= 5 && n <= 10);

        } else if(x == 2){
            int n = 0;
            int counter = 0;

            do{
                System.out.print("Digite um valor entre 5 e 10: ");
                n = scanner.nextInt();
                if(n < 5 || n > 10) counter++;
            } while(counter < 5);
        }
        System.out.println("Programa encerrado");
    }
}
