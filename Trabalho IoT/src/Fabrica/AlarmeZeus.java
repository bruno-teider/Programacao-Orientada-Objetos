package Fabrica;

public class AlarmeZeus extends Alarme{
    public void aplicar(double valor) {
        super.critico = 5;

        if(valor >= critico) super.estado = 1;
        else super.estado = 0;
    }

    public int getValor() { return super.estado; }
}
