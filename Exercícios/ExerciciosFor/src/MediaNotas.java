import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int soma = 0;

        for(int i = 0; i < 20; i++){
            System.out.print("Digite a " + (i+1) + "° nota: ");
            int n = scanner.nextInt();
            soma = soma + n;
        }

        int media = soma/20;
        System.out.println("A media das notas foi " + media);

    }
}
