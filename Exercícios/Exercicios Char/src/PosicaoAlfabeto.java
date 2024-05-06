import java.util.Scanner;

public class PosicaoAlfabeto {

    public static void Posicao(char letra){
        int posicao = letra - 96;
        System.out.println("A posição da letra no alfabeto é " + posicao);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char letra;

        do{
            System.out.print("Digite uma letra: ");
            String frase = scanner.next();
            frase = frase.toLowerCase();
            letra = frase.charAt(0);
        } while(letra < 97 || letra > 122);

        Posicao(letra);
    }
}
