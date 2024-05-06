import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Consulta {
    LocalDateTime data_hora;
    ArrayList<Medico> medicos = new ArrayList<>();

    public Consulta(LocalDateTime data_hora){ this.data_hora = data_hora; }
    public void incluir_medico(Medico medico){ this.medicos.add(medico); }
}
