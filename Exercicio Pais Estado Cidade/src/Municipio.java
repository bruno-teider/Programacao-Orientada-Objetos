public class Municipio {
    private int populacao;
    private double area;

    public Municipio(int populacao, double area) {
        this.populacao = populacao;
        this.area = area;
    }

    public int populacao() { return populacao; }

    public double area() { return area; }

    public double densidade() { return populacao / area; }
}