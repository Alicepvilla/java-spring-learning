package tienda.model;

import tienda.model.util.Persona;
import tienda.model.util.Vehiculo;

public class Trabajador extends Persona {
    private Vehiculo vehiculo;

    public Trabajador() {
        super();
    }

    public Trabajador(Long id, String nombre, String run, String telefono, Vehiculo vehiculo) {
        super(id, nombre, run, telefono);
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                super.toString() +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
