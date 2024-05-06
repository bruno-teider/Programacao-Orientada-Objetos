public class IBGE {
    public static void main(String args[])
    {
        Municipio curitiba = new Municipio(2400, 400);
        Municipio guarapuava = new Municipio( 200, 100);
        Municipio londrina = new Municipio( 800, 300);
        Municipio maringa = new Municipio( 600, 200);

        Estado parana = new Estado();
        parana.adicionar_municipio(curitiba);
        parana.adicionar_municipio(guarapuava);
        parana.adicionar_municipio(londrina);
        parana.adicionar_municipio(maringa);

        Municipio salvador = new Municipio(3000, 400);
        Municipio juazeiro = new Municipio( 400, 100);
        Municipio ilheus = new Municipio(280, 200);
        Municipio itabuna = new Municipio( 320, 300);

        Estado bahia = new Estado();
        bahia.adicionar_municipio(salvador);
        bahia.adicionar_municipio(juazeiro);
        bahia.adicionar_municipio(ilheus);
        bahia.adicionar_municipio(itabuna);

        Pais brasil = new Pais();
        brasil.adicionar_estado(parana);
        brasil.adicionar_estado(bahia);

        System.out.println("Densidade de Curitiba: " + curitiba.densidade() );
        System.out.println("Densidade do Paraná: " + parana.densidade() );
        System.out.println("Área da Bahia: " +bahia.area() );
        System.out.println("População do Brasil: " +brasil.populacao() );
        System.out.println("Densidade do Brasil: " +brasil.densidade() );
    }
}
