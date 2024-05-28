package Casa;

public class ControleArCondicionadoSpringer extends ControleArCondicionado {
    public void aplicar(double temp){
        if((temp < super.temp_min) && (super.pot_atual < super.pot_max-1))
            super.pot_atual += 2;
        else if((temp > super.temp_max) && (super.pot_atual > 1))
            super.pot_atual -= 2;
    }

    public int getValor(){ return super.pot_atual; }
}
