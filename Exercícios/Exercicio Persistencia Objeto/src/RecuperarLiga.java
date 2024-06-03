import java.io.IOException;

public class RecuperarLiga {
    public static void main(String[] args) {
        try {
            Liga liga = Liga.abrir("Champions.ser");
            System.out.println("Liga recuperada com sucesso!");
            liga.exibir();
        } catch (IOException e) {
            System.out.println("Excecao de I/O");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Excecao de classe desconhecida");
            e.printStackTrace();
        }
    }
}