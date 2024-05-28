package Fabrica;

import java.util.Random;

public class NivelFumacaFireray extends NivelFumaca{
    public NivelFumacaFireray(double valor) { super(valor); }

    // Variação nível fumaça
    public double ler_dado() {
        Random random = new Random();
        int number = random.nextInt(2);

        if(number == 0 && super.nivel > 0) super.nivel -= 2;
        else super.nivel += 2;

        return super.nivel;
    }
}
