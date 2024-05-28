package Fabrica;

import java.util.Random;

public class NivelFumacaPurelight extends NivelFumaca{
    public NivelFumacaPurelight(double valor){ super(valor); }

    public double ler_dado() {
        Random random = new Random();
        int number = random.nextInt(2);

        if(number == 0 && super.nivel > 0) super.nivel -= 1;
        else super.nivel += 1;

        return super.nivel;
    }
}
