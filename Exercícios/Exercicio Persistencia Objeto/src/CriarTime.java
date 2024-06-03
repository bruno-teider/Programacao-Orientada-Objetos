import java.io.IOException;

public class CriarTime {
    public static void main(String[] args){
        Time time = new Time("TimeLegal", "Frank", 30, "Alcides", 10, "Eduardo Lino");
        time.exibir();

        try{
            time.salvar("TimeLegal.ser");
            System.out.println("Time criado e salvo com sucesso!");
        } catch (IOException e){
            System.out.println("Erro de I/O");
            e.printStackTrace();
        }
    }
}
