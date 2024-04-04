public class Main {
    public static void main(String args[]) {

        PessoaFisica Bruno = new PessoaFisica("Bruno", 987861433);
        PessoaFisica Pedro = new PessoaFisica("Pedro", 998564433);

        Imobiliaria ImobiliariaLegal = new Imobiliaria("ImobiliariaLegal");

        Apartamento apartamento1 = new Apartamento(1, 55, 10);
        Apartamento apartamento2 = new Apartamento(2, 40, 5);

        apartamento1.fixar_preco(100.000F);
        apartamento1.fixar_proprietario(Bruno);
        apartamento2.fixar_proprietario(Pedro);

        ImobiliariaLegal.incluir_apartamento(apartamento1);
        ImobiliariaLegal.incluir_apartamento(apartamento2);

        Bruno.show();
        Pedro.show();

        ImobiliariaLegal.show();
    }
}
