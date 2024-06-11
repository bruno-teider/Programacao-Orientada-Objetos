import java.util.ArrayList;

public class Medico {
    public String nome;
    public int codigo;
    ArrayList<Paciente> pacientes = new ArrayList<>();

    // Método Construtor
    public Medico(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    public void incluir_paciente(Paciente paciente){ this.pacientes.add(paciente); }
}
