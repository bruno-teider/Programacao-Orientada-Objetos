public class ExcecaoSeguranca extends Exception{
    public ExcecaoSeguranca(String mensagem){
        super("Erro de segurança: " + mensagem);
    }
}
