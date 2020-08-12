package tienda.model;

import tienda.model.util.Vehiculo;

public class Bicicleta extends Vehiculo {

    private Double dimensionesRuedas;

    public Bicicleta() {
        super();
    }

    public Bicicleta(Long id, String modelo, String marca, Double dimensionesRuedas) {
        super(id, modelo, marca);
        this.dimensionesRuedas = dimensionesRuedas;
    }

    public Double getDimensionesRuedas() {
        return dimensionesRuedas;
    }

    public void setDimensionesRuedas(Double dimensionesRuedas) {
        this.dimensionesRuedas = dimensionesRuedas;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                super.toString() +
                ", dimensionesRuedas=" + dimensionesRuedas +
                '}';
    }
}
