package tienda.model;

import tienda.model.util.Vehiculo;

public class Moto extends Vehiculo {
    private String patente;
    private int anoFabricacion;

    public Moto() {
        super();
    }

    public Moto(Long id, String modelo, String marca, String patente, int anoFabricacion) {
        super(id, modelo, marca);
        this.patente = patente;
        this.anoFabricacion = anoFabricacion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    @Override
    public String toString() {
        return "Moto{" +
                super.toString() +
                ", patente='" + patente + '\'' +
                ", anoFabricacion=" + anoFabricacion +
                '}';
    }
}
