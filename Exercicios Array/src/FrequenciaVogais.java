import java.util.Scanner;

public class FrequenciaVogais {

    public static char[] CriarArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de letras que deseja adicionar: ");
        int n = scanner.nextInt();

        char[] array = new char[n];

        for (int i = 0; i < n; i++){
            System.out.print("Digite uma letra: ");
            String frase = scanner.next();
            frase = frase.toLowerCase();
            char letra = frase.charAt(0);

            if (letra > 96 & letra < 123) array[i] = letra;
            else System.out.println("Valor Inválido");
        }

        return array;
    }

    public static void Frequencia(char[] array){
        int vogal = 0;
        double porcentagem = 0;

        for (char c : array) {
            if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117)
                vogal++;
        }

        porcentagem = (vogal*100)/array.length;
        System.out.println(porcentagem + "% dos valores inclusos são vogais.");
    }

    public static void main(String[] args){
        char[] array = CriarArray();
        Frequencia(array);
    }
}
