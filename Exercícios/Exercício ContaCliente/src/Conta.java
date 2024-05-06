public class Conta {
    public int numero_conta;
    public float saldo;
    private Cliente cliente;

    public Conta(int numero_conta, float saldo){
        this.numero_conta = numero_conta;
        this.saldo = saldo;
    }

    public void definir_cliente(Cliente cliente){ this.cliente = cliente; }

    public void exibir_dados_essenciais(){ System.out.println("Número da conta: " + numero_conta); }

    public void exibir_dados_completos(){
        System.out.println("Conta: " + numero_conta);
        System.out.println("    saldo:" + saldo);
        if(cliente == null) System.out.println("    cliente indefinido");
        else System.out.println("    Cliente: " + cliente.nome);
    }

}
