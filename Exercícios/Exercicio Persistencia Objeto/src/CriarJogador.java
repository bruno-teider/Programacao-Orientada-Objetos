import java.io.IOException;

public class CriarJogador {
    public static void main(String[] args){
        Jogador jogador = new Jogador("Jedi", 100);
        jogador.posicionar(5);
        jogador.exibir();

        try {
            jogador.salvar("Jedi.ser");
            System.out.println("Jogador criado e salvo com sucesso!");
        } catch (IOException e){
            System.out.println("Exceção de I/O");
            e.printStackTrace();
        }
    }
}
