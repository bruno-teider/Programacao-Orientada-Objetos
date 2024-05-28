package Casa;

import java.util.Random;

public class TermometroTuya extends Termometro {
    public TermometroTuya(int ultima_temp) { super(ultima_temp); };

    public double ler_dado() {
        Random random= new Random();

        // Gera 0 ou  1 para saber se aumenta ou diminui a temp
        int number =  random.nextInt(2);

        if(number ==0) super.ultima_temp -= 1;
        else super.ultima_temp += 1;

        return super.ultima_temp;
    }
}
