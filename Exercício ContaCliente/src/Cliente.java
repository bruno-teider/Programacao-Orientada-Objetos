public class Cliente {
    public String nome;
    private int cpf;
    private int telefone;
    private Conta conta;

    public Cliente(String nome, int cpf, int telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public void atualizar_telefone(int telefone){ this.telefone = telefone; }

    public void definir_conta(Conta conta){ this.conta = conta; }

    public void exibir_dados_essenciais(){ System.out.println("Nome: " + nome); }

    public void depositar(float valor_deposito){ conta.saldo += valor_deposito; }

    public void retirar(float valor_retirado){ conta.saldo -= valor_retirado; }

    public void exibir_dados_completos(){
        System.out.println("Cliente: " + nome);
        System.out.println("    CPF:" + cpf);
        System.out.println("    telefone:" + telefone);
        if(conta == null) System.out.println("    conta indefinida");
        else System.out.println("    conta:" + conta.numero_conta);
    }
}
