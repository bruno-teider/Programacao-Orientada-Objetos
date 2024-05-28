package FrameworkIoT;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class GerenciadorAmbiente {
    private ArrayList<Par_IoT> pares_IoT = new ArrayList<Par_IoT>();
    public void incluir(Par_IoT par) { pares_IoT.add(par); }
    public void monitorar_ambiente() {
        while (true) {
            System.out.println("\n[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "]:");
            for (Par_IoT par: pares_IoT)
            {
                double dado = par.sensor.ler_dado();
                System.out.print(String.format("(%20s) Dado lido: %.2f ==> ", par.ID, dado));
                par.atuador.aplicar(dado);
                System.out.print( par.atuador.getTipo() +" = " + par.atuador.getValor() + " \n");
            }
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}
