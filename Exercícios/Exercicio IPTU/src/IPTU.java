import java.util.Scanner;

public class IPTU {
    public static class Imovel{
        Scanner scanner = new Scanner(System.in);
        private int codigo;
        private double area_terreno;
        private double area_construida;
        private int cod_bairro;
        private double valor_iptu;

        public void populaClasse() {
            System.out.print("\nDigite um código para o imóvel: ");
            this.codigo = scanner.nextInt();
            System.out.print("Digite o valor da área do terreno: ");
            this.area_terreno = scanner.nextDouble();
            System.out.print("Digite o valor da área construida: ");
            this.area_construida = scanner.nextDouble();
            System.out.print("Digite o código do bairro: ");
            this.cod_bairro = scanner.nextInt();
            valorIptu();
        }

        private void valorIptu(){
            double imposto;
            if(cod_bairro == 0 || cod_bairro == 1 || cod_bairro == 2) imposto = (area_terreno * 1) + (area_construida * 2);
            else if (cod_bairro == 3 || cod_bairro == 4|| cod_bairro == 5) imposto = (area_terreno * 0.5) + (area_construida * 1);
            else imposto = (area_terreno * 0.25) + (area_construida * 0.5);

            this.valor_iptu = imposto;
        }
        private void descImovel(){
            System.out.println("\nCódigo: " + codigo);
            System.out.println("Area do terreno: " + area_terreno);
            System.out.println("Area construida: " + area_construida);
            System.out.println("Código bairro: " + cod_bairro);
            System.out.println("Valor Iptu: " + valor_iptu);
        }
    }

    public static void main(String[] args){
        Imovel imovel1 = new Imovel();
        Imovel imovel2 = new Imovel();
        Imovel imovel3 = new Imovel();

        imovel1.populaClasse();
        imovel2.populaClasse();
        imovel3.populaClasse();

        imovel1.descImovel();
        imovel2.descImovel();
        imovel3.descImovel();
    }
}