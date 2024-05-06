public class Apartamento {
    private int codigo;
    private float area_privada;
    private float area_comum;
    private float preco = 0;
    private PessoaFisica proprietario;

    public Apartamento(int codigo, float area_privada, float area_comum){
        this.codigo = codigo;
        this.area_comum = area_comum;
        this.area_privada = area_privada;
    }

    public void fixar_preco(float preco) { this.preco = preco; }

    public void fixar_proprietario(PessoaFisica pessoa){ this.proprietario = pessoa; }

    public void fixar_preco(){

    }

    public void show(){
        System.out.println("Código: " + codigo);
        System.out.println("Área Comum: " + area_comum + "m");
        System.out.println("Área Privada: " + area_privada + "m");

        if (preco == 0) System.out.println("Preço: Indefinido");
        else System.out.println("Preço: " + preco);

        if (proprietario == null) System.out.println("Proprietário: Indefinido");
        else System.out.println("Proprietário: " + proprietario.nome());
    }
}
