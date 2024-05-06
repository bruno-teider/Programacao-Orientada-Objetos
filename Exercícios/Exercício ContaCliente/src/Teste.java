public class Teste {
    public static void main(String args[]){
        System.out.println("\nCriando Dois Clientes ...");

        Cliente john = new Cliente("John", 135, 111);
        Cliente steve = new Cliente("Steve", 246, 222);

        john.exibir_dados_completos();
        steve.exibir_dados_completos();

        System.out.println("\nCriando Duas Contas ...");

        Conta conta1 = new Conta(777, 500.00F);
        Conta conta2 = new Conta(888, 1000.00F);

        conta1.exibir_dados_completos();
        conta2.exibir_dados_completos();

        System.out.println("\nLigando Contas a Cliente ...");

        john.definir_conta(conta1);
        conta1.definir_cliente(john);

        steve.definir_conta(conta2);
        conta2.definir_cliente(steve);

        john.exibir_dados_completos();
        steve.exibir_dados_completos();

        conta1.exibir_dados_completos();
        conta2.exibir_dados_completos();

        System.out.println("\nAlterando Cliente e Conta ...");

        john.depositar(300.00F);
        john.retirar(100F);
        conta1.exibir_dados_completos();

        john.atualizar_telefone(999);
        john.exibir_dados_completos();
    }
}
