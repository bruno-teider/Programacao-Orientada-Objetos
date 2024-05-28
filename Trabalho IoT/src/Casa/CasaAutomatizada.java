package Casa;

import java.util.Random;
import FrameworkIoT.*;

public class CasaAutomatizada {
    public static void main(String[] args){
        Random random = new Random();

        // Senores (gera valores aleatorios entre 20 e 25 para temp inicial)
        Termometro nexcon1 = new TermometroNexcon(random.nextInt((25 - 20)+1) + 20);
        Termometro tuya1 = new TermometroTuya(random.nextInt((25 - 20)+1) + 20);
        Termometro nexcon2 = new TermometroNexcon(random.nextInt((25 - 20)+1) + 20);
        Termometro tuya2 = new TermometroTuya(random.nextInt((25 - 20)+1) + 20);

        // Atuadores
        ControleArCondicionado agratto1 = new ControleArCondicionadoAgratto();
        ControleArCondicionado springer1 = new ControleArCondicionadoSpringer();
        ControleArCondicionado agratto2 = new ControleArCondicionadoAgratto();
        ControleArCondicionado springer2 = new ControleArCondicionadoSpringer();

        // Pares IoT
        Par_IoT master = new Par_IoT("Suíte Master", nexcon1, agratto1);
        Par_IoT criancas = new Par_IoT("Suíte Criança", tuya1, springer1);
        Par_IoT sala = new Par_IoT("Sala de Estar", nexcon2, springer2);
        Par_IoT cozinha = new Par_IoT("Cozinha", tuya2, agratto2);

        GerenciadorAmbiente casa = new GerenciadorAmbiente();
        casa.incluir(master);
        casa.incluir(criancas);
        casa.incluir(sala);
        casa.incluir(cozinha);

        casa.monitorar_ambiente();
    }
}
