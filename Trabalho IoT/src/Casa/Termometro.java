package Casa;

import FrameworkIoT.Sensor;

public abstract class Termometro implements Sensor {
    public int ultima_temp;

    public Termometro(int ultima_temp){
        this.ultima_temp = ultima_temp;
    }
}
