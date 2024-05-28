package Fabrica;

import FrameworkIoT.Sensor;

public abstract class NivelFumaca implements Sensor{
    public double nivel;

    public NivelFumaca(double nivel){ this.nivel = nivel; }
}
