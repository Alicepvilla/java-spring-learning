package tienda.model;

import tienda.model.util.Persona;
import tienda.model.util.Vehiculo;

import java.util.ArrayList;
import java.util.List;

import static tienda.util.Init.*;

public class Tienda {

    private List<Pedido> registros = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private List<Persona> trabajadores = new ArrayList<>();

    public Tienda() {
        this.vehiculos = initVehiculos(vehiculos);
        this.trabajadores = initTrabajadores(trabajadores, vehiculos);
    }

    public List<Pedido> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Pedido> registros) {
        this.registros = registros;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Persona> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Persona> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
