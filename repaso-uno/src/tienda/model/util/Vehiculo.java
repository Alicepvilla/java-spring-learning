package tienda.model.util;

public abstract class Vehiculo {
    private Long id;
    private String modelo, marca;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String modelo, String marca) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca;
    }
}
