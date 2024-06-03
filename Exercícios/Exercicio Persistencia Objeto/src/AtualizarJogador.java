import java.io.*;

public class AtualizarJogador {
    public static void main(String[] args) {
        String nome_arquivo = "Jedi.ser";

        try {
            Jogador jogador = Jogador.abrir(nome_arquivo);
            System.out.println("Jogador restaurado com sucesso!");
            jogador.exibir();

            jogador.posicionar(20);
            jogador.pontuar();
            jogador.exibir();

            jogador.salvar(nome_arquivo);
            System.out.println("Jogador salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro de I/O");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro classe não encontrada");
            e.printStackTrace();
        }
    }
}
