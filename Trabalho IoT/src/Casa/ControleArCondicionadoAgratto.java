package Casa;

public class ControleArCondicionadoAgratto extends ControleArCondicionado {
    public void aplicar(double temp){
        if((temp < super.temp_min) && (super.pot_atual < super.pot_max))
            super.pot_atual++;
        else if((temp > super.temp_max) && (super.pot_atual > 0))
            super.pot_atual--;
    }

    public int getValor(){ return super.pot_atual; }
}
