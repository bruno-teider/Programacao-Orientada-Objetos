import java.util.Random;

public class Main {
    public static void main(String[] args){
        Banco santander = new Banco("Santander");

        // Criar as contas
        for(int i = 0; i < 5; i++){
            santander.criar_conta(i+1, Integer.toString(i+1), 100 );
        }

        // Erro Horário Inválido depende da hora do computador
        santander.sacar(1, "2", 10); // Senha Errada
        santander.sacar(2, "2", 101); // Saldo Inssuficiente
        santander.sacar(6, "6", 10); // Conta Inválida

        santander.sacar(1, "1", 10);
        santander.sacar(2, "2", 20);
        santander.sacar(3, "3", 30);
        santander.sacar(4, "4", 40);
        santander.sacar(5, "5", 50);
    }
}
