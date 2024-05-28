package Fabrica;

import FrameworkIoT.Atuador;

public abstract class Alarme implements Atuador {
    int critico; // Quantidade de gás nescessária para ligar o alarme
    int estado; // 0 ou 1 para saber se o Alarme está ligado

    public String getTipo() { return "Ativado[0/1]"; }

}
