import java.io.*;

public class RecuperarJogador {
    public static void main(String[] args){
        try {
            Jogador jogador = Jogador.abrir("Jedi.ser");
            System.out.println("Jogador restaurado com sucesso!");
            jogador.exibir();
        } catch (IOException e){
            System.out.println("Erro de I/O");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Erro classe desconhecida");
            e.printStackTrace();
        }
    }
}

