import java.util.Scanner;

public class ContarVogaisConsoantes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int vogais = 0;
        int consoantes = 0;
        int outros = 0;

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        frase = frase.toLowerCase();

        for(int i = 0; i < frase.length(); i++){
            char letra;
            letra = frase.charAt(i);

            switch(letra){
                case 97,101,105,111,117:
                    vogais++;
                    break;
                case 98,99,100,102,103,104,106,107,108,109,110,112,113,114,115,116,118,119,120,121,122:
                    consoantes++;
                    break;
                default:
                    outros++;
                    break;
            }
        }

        System.out.println("Vogais: "+vogais+"| Consoantes: "+consoantes+"| Outros: "+outros);
    }
}
