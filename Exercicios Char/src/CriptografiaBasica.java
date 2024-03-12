import java.util.Scanner;

public class CriptografiaBasica {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String frase_cripto = "";

        System.out.print("Digite uma frase para ser criptografada: ");
        String frase = scanner.nextLine();

        for(int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);
            letra += 5;
            frase_cripto += letra;
        }

        System.out.println("Frase Criptografada: " + frase_cripto);
    }
}
