package Casa;

import java.util.Random;

public class TermometroNexcon extends Termometro {
    public TermometroNexcon(int ultima_temp){ super(ultima_temp); }

    // Variação de 2 graus da ultima_temp
    public double ler_dado() {
        Random random = new Random();

        // Gera 0 ou 1 para saber se aumenta ou diminui a temperatura
        int number = random.nextInt(2);

        if(number == 0) super.ultima_temp -= 2;
        else super.ultima_temp += 2;

        return super.ultima_temp;
    }
}
