package tienda.util;

import tienda.model.Bicicleta;
import tienda.model.Moto;
import tienda.model.Trabajador;
import tienda.model.util.Persona;
import tienda.model.util.Vehiculo;

import java.util.List;

public class Init {
    public static List<Vehiculo> initVehiculos(List<Vehiculo> vehiculos) {
        vehiculos.add(new Moto((long) vehiculos.size() + 1, "RTX150", "Honda", "PT-DS-51", 2015));
        vehiculos.add(new Bicicleta((long) vehiculos.size() + 1, "K15", "Trek", 26.0));
        vehiculos.add(new Moto((long) vehiculos.size() + 1, "JFI", "Honda", "AS-LK-45", 2018));
        return vehiculos;
    }

    public static List<Persona> initTrabajadores(List<Persona> trabajadores, List<Vehiculo> vehiculos) {
        trabajadores.add(new Trabajador(
                (long) (trabajadores.size() + 1),
                "Eduardo Garrido",
                "15648579-5",
                "+56958964715",
                vehiculos.get(trabajadores.size())));

        trabajadores.add(new Trabajador(
                (long) (trabajadores.size() + 1),
                "Lucía Campusano",
                "18569458-K",
                "+56967849532",
                vehiculos.get(trabajadores.size())));

        trabajadores.add(new Trabajador(
                (long) (trabajadores.size() + 1),
                "Cristian González",
                "13456854-7",
                "+56975486925",
                vehiculos.get(trabajadores.size())));

        return trabajadores;
    }
}
