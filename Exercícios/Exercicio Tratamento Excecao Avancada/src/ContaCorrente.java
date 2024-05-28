public class ContaCorrente {
    private int numero;
    private String senha;
    private double saldo;

    public ContaCorrente(int numero, String senha, double saldo){
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void retirar(double valor, String senha) throws ExcecaoSaldoInsuficiente, ExcecaoSenhaInvalida {
        if(saldo < valor) throw new ExcecaoSaldoInsuficiente();
        if(!this.senha.equals(senha)) throw new ExcecaoSenhaInvalida();

        saldo -= valor;
        System.out.println("Saldo na conta " + numero + " é de R$" + saldo);
    }

    public int getNumero() { return numero; }
}
