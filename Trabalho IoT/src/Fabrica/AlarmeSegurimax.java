package Fabrica;

public class AlarmeSegurimax extends Alarme{
    public void aplicar(double valor) {
        super.critico = 7;

        if(valor >= critico) super.estado = 1;
        else super.estado = 0;
    }

    public int getValor() { return super.estado; }
}
