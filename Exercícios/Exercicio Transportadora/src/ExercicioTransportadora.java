import java.util.Scanner;

public class ExercicioTransportadora {

    public static class Transportadora{
        private String placa;
        private int ano;
        private int km;
        private int viagens;
        private float media_viagem;
        private float media_ano;

        private void populaClasse(){
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nDigite a placa do caminhão: ");
            this.placa = scanner.next();
            System.out.print("Digite o ano de aquisição do caminhão: ");
            this.ano = scanner.nextInt();
            System.out.print("Digite a quilometragem do caminhão: ");
            this.km = scanner.nextInt();
            System.out.print("Diginte a quantidade de viagens desse caminhão: ");
            this.viagens = scanner.nextInt();

            this.media_viagem = (km/viagens);
            this.media_ano = km/(2024 - ano);
        }
        private void descCaminhao(){
            System.out.println("\nPlaca do caminhão: " + placa);
            System.out.println("Ano de aquisição: " + ano);
            System.out.println("Quilometragem do caminhão" + km);
            System.out.println("Quantidade de viagens: " + viagens);
            System.out.println("Quilometragem média por viagem: " + media_viagem);
            System.out.println("Quilometragem média por ano: " + media_ano);
        }
    }

    public static void main(String[] args){
        Transportadora caminhao = new Transportadora();
        caminhao.populaClasse();
        caminhao.descCaminhao();
    }
}
