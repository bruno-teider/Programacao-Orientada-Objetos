import java.io.*;

public class Jogador implements Serializable {
    private String nome;
    private int pontuacao;
    transient private float distancia; // Não será persistente

    public Jogador(String nome, int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public void posicionar(float distancia){this.distancia = distancia;}

    public void pontuar(){
        pontuacao++;
        distancia = distancia/2;
    }

    public void exibir(){System.out.println(nome + ": " + pontuacao + ", " + distancia);}

    // Salvar objeto persistente
    public void salvar(String nome_arquivo) throws IOException{
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    // Abrir um objeto persistente salvo
    public static Jogador abrir(String nome_arquivo) throws IOException, ClassNotFoundException{
        Jogador jogador = null;

        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        jogador = (Jogador) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return jogador;
    }
}
