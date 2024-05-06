import java.util.ArrayList;

public class Paciente {
    public String nome;
    public String CPF;
    ArrayList<Consulta> consultas = new ArrayList<>();

    // Método Construtor
    public Paciente(String nome, String CPF){
        this.nome = nome;
        this.CPF = CPF;
    }

    public void incluir_consulta(Consulta consulta){ this.consultas.add(consulta); }
}
