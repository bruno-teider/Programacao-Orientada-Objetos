package FrameworkIoT;

public class Par_IoT {
    String ID;
    Sensor sensor;
    Atuador atuador;
    public Par_IoT(String ID, Sensor sensor, Atuador atuador) {
        this.ID = ID;
        this.sensor = sensor;
        this.atuador = atuador;
    }
}