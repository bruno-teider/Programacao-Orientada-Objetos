import java.io.*;

public class Time implements Serializable {
    private String nome;
    private Jogador jogador1;
    private Jogador jogador2;
    private Treinador treinador;

    public Time(String nome_time, String nome_1, int pontuacao_1, String nome_2, int pontuacao_2, String nome_treinador) {
        this.nome = nome_time;
        jogador1 = new Jogador(nome_1, pontuacao_1);
        jogador2 = new Jogador(nome_2, pontuacao_2);
        treinador = new Treinador(nome_treinador);
        jogador1.posicionar(8.0f);
        jogador2.posicionar(14.0f);
    }

    public void exibir() {
        System.out.println(nome);
        jogador1.exibir();
        jogador2.exibir();
        treinador.exibir();
    }

    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public static Time abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        Time time = null;
        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        time = (Time) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return time;
    }
}