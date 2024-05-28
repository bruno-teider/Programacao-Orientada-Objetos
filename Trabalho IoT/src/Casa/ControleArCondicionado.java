package Casa;

import FrameworkIoT.Atuador;

public abstract class ControleArCondicionado implements Atuador{
    double temp_min = 20;
    double temp_max = 22;
    int pot_max = 10;
    int pot_atual = 6;

    public String getTipo() { return "Potência"; }
}
