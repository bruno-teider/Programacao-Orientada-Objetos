package Fabrica;

import Casa.*;
import FrameworkIoT.*;
import java.util.Random;

public class FabricaAutomatizada {
    public static void main(String[] args){
        Random random = new Random();

        // Geração Sensoress
        Termometro nexcon = new TermometroNexcon(random.nextInt((25 - 20)+1) + 20);
        NivelFumaca fireray = new NivelFumacaFireray(random.nextInt(4));
        NivelFumaca purelight = new NivelFumacaPurelight(random.nextInt(4));

        // Geração Atuadores
        ControleArCondicionado agratto = new ControleArCondicionadoAgratto();
        Alarme segurimax = new AlarmeSegurimax();
        Alarme zeus = new AlarmeZeus();

        // Criação Pares
        Par_IoT escritorio = new Par_IoT("Escritório", nexcon, agratto);
        Par_IoT producao = new Par_IoT("Produção", fireray, segurimax);
        Par_IoT montagem = new Par_IoT("Montagem", purelight, zeus);

        // Gerenciador Ambientes
        GerenciadorAmbiente fabrica = new GerenciadorAmbiente();
        fabrica.incluir(escritorio);
        fabrica.incluir(producao);
        fabrica.incluir(montagem);

        fabrica.monitorar_ambiente();
    }
}
