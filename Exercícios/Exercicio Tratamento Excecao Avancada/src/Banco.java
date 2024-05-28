import java.time.LocalTime;
import java.util.ArrayList;

public class Banco {
    String nome;
    ArrayList<ContaCorrente> contas = new ArrayList<>();

     public Banco(String nome){ this.nome = nome; }

    public void criar_conta(int numero, String senha, double saldo){
       contas.add(new ContaCorrente(numero, senha, saldo));
    }

    public void sacar(int numero, String senha, double valor){
         try{
             int hora = LocalTime.now().getHour();
             if((hora < 8) || (hora > 22)) throw new ExcecaoHorarioInvalido();

             boolean achou = false;
             for(ContaCorrente conta : contas){
                 if(conta.getNumero() == numero){
                     try {
                         achou = true;
                         conta.retirar(valor, senha);
                     } catch (ExcecaoSaldoInsuficiente | ExcecaoSenhaInvalida e) { e.printStackTrace(); } ;
                 }
             }
             if(!achou) throw new ExcecaoContaInvalida();
         } catch (ExcecaoContaInvalida | ExcecaoHorarioInvalido e){e.printStackTrace();}
    }
}
