import java.util.Scanner;

public class desvioPadrao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite quantos valores você deseja adicionar: ");
        int n = scanner.nextInt();
        if (n < 3 || n > 5) System.out.println("Valor deve ser entre 3 e 5");
        else{
            int soma = 0;

            for(int i = 0; i < n; i++){
                System.out.print("Digite o " + (i+1) + "° valor: ");
                int x = scanner.nextInt();
                soma = soma + x;
            }

            System.out.println("A média dos valores foi " + (soma/n));

        }
    }
}