import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public class Functions {
        private static int Print(){
            int op = 0;
            System.out.println("Qual operação deseja realizar: ");
            System.out.println("1 - Converte em maiúsculas \n" +
                    "2 - Converte em minúsculas \n" +
                    "3 - Extrair uma substring \n" +
                    "4 - Localizar uma substring fornecida \n" +
                    "5 - Verificar se duas strings são iguais");
            do {
                System.out.print("Digite sua opção: ");
                op = scanner.nextInt();
            } while(op <= 0 || op > 5);

            return op;
        }
        private static void Maiusculo(String frase){System.out.println("Frase em maiúsculo: " + frase.toUpperCase());}
        private static void Minusculo(String frase){System.out.println("Frase em minúsculo: " + frase.toLowerCase());}
        private static void ExtrairSubstring(String frase){
            System.out.print("Selecione um endereço para começar a substring: ");
            int valor1 = scanner.nextInt();
            System.out.println("Selecione um endereço para terminar a substring: ");
            int valor2 = scanner.nextInt();

            try {System.out.println("Substring retirada foi: " + frase.substring(valor1, valor2));}
            catch(Exception e){System.out.println("Valor Inválido");}
        }
        private static void LocalizarSubstring(String frase){
            System.out.print("Digite uma substring para ser localizada: ");
            String substring = scanner.next();
            System.out.println(frase.indexOf(substring));
        }
        private static void ComparaString(String frase){
            System.out.print("Digite uma frase para comparar: ");
            scanner.nextLine();
            String frase2 = scanner.nextLine();
            if(frase.equalsIgnoreCase(frase2) == true) System.out.println("Frases iguais.");
            else System.out.println("Frases diferentes");
        }
    }


    public static void main(String[] args) {
        System.out.print("Digite alguma frase: ");
        String frase = scanner.nextLine();
        int op = Functions.Print();

        switch (op){
            case 1: Functions.Maiusculo(frase); break;
            case 2: Functions.Minusculo(frase); break;
            case 3: Functions.ExtrairSubstring(frase); break;
            case 4: Functions.LocalizarSubstring(frase); break;
            case 5: Functions.ComparaString(frase); break;
        }
    }
}