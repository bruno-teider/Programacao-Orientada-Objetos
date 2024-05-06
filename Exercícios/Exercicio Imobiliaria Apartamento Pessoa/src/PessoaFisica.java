public class PessoaFisica {
    private String nome;
    private int telefone;

    public PessoaFisica(String nome, int telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public void show(){
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
    }

    public String nome(){
        return nome;
    }
}
