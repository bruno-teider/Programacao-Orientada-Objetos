import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número que deseja ver o fatorial: ");
        int n = scanner.nextInt();

        int f = 1;
        for(int i = n; i > 1; i--){
            f = f * n;
            n--;
        }
        System.out.println("Valor do fatorial é " + f);
    }
}
