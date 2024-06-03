import java.util.ArrayList;
import java.io.*;

public class Liga implements Serializable {
    ArrayList<Time> times;

    public Liga() {
        times = new ArrayList<Time>();
        times.add(new Time("Big Cats", "Lion", 13, "Jaguar", 21, "Felix"));
        times.add(new Time("Flyers", "Bat", 30, "Eagle", 22, "Dumont"));
        times.add(new Time("Swimmers", "Shark", 70, "Dolphin", 40, "Verne"));
    }

    public void exibir() {
        for (Time t : times) t.exibir();
    }

    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public static Liga abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        Liga liga = null;

        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        liga = (Liga) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return liga;
    }
}