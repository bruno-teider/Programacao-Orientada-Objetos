import java.io.IOException;

public class CriarLiga {
    public static void main(String[] args) {
        Liga liga = new Liga();
        liga.exibir();

        try {
            liga.salvar("Champions.ser");
            System.out.println("Liga criada e salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Excecao de I/O");
            e.printStackTrace();
        }
    }
}
