import java.util.ArrayList;

public class Pais {
    ArrayList<Estado> estado_arraylist = new ArrayList<Estado>();

    public void adicionar_estado(Estado estado){
        estado_arraylist.add(estado);
    }

    int populacao() {
        int populacao = 0;
        for(Estado estado : estado_arraylist){
            populacao += estado.populacao();
        }

        return  populacao;
    }
    double area() {
        double area = 0;
        for(Estado estado : estado_arraylist){
            area += estado.area();
        }

        return area;
    }
    double densidade() { return populacao() / area(); }
}
