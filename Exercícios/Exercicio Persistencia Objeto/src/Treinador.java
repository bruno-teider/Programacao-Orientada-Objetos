import java.io.Serializable;

public class Treinador implements Serializable {
    private String nome;

    public Treinador(String nome) {this.nome = nome;}

    public void exibir(){System.out.println("Treinador: " + nome);}
}
