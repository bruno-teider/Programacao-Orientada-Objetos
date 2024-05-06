import java.util.Scanner;

public class ConverteNumeroString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        System.out.print("Digite um valor: ");
        n = scanner.nextInt();

        System.out.println("Correspondente em char: " + (char)n);

    }
}