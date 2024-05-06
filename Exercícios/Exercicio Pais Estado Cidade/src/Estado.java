import java.util.ArrayList;

public class Estado {
    ArrayList<Municipio> municipio_arraylist = new ArrayList<Municipio>();

    public void adicionar_municipio(Municipio municipio){
        this.municipio_arraylist.add(municipio);
    }

    public int populacao() {
        int populacao = 0;
        for (Municipio municipio : municipio_arraylist){
            populacao += municipio.populacao();
        }

        return populacao;
    }
    public double area() {
        double area = 0;
        for(Municipio municipio : municipio_arraylist){
            area += municipio.area();
        }

        return area;
    }
    double densidade() { return populacao() / area(); }
}