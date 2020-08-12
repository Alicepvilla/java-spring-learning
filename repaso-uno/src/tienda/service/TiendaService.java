package tienda.service;

import tienda.model.*;
import tienda.model.util.Persona;
import tienda.model.util.Vehiculo;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TiendaService {
    private static final Scanner scanner = new Scanner(System.in);

    public static void calcularTotalGanado(Tienda tienda) {
        StringBuilder stringBuilder = new StringBuilder("\nTOTAL GANADO\n");
        stringBuilder.append("$" + tienda.getRegistros()
                .stream()
                .mapToInt(Pedido::getMonto)
                .sum());
        stringBuilder.append("\n\n*******************\n");
        stringBuilder.append("Presiona enter...\n");
        System.out.println(stringBuilder);
        scanner.nextLine();
    }

    public static Pedido addPedido(Tienda tienda) {
        Pedido pedido = new Pedido();
        System.out.println("\nAGREGAR PEDIDO");

        pedido.setId((long) tienda.getRegistros().size() + 1);
        System.out.print("Nombre cliente: ");
        pedido.setNombreCliente(scanner.nextLine());
        System.out.print("Comuna: ");
        pedido.setComuna(scanner.nextLine());
        System.out.print("Dirección inicio: ");
        pedido.setDireccionInicio(scanner.nextLine());
        System.out.print("Dirección fin: ");
        pedido.setDireccionFin(scanner.nextLine());
        System.out.print("Monto: ");
        pedido.setMonto(Integer.parseInt(scanner.nextLine()));

        int selection = 0;
        while (true) {
            try {
                mostrarTrabajadores(tienda.getTrabajadores());
                selection = Integer.parseInt(scanner.nextLine());
                if (selection > 0 && selection <= tienda.getTrabajadores().size() + 1) {
                    pedido.setTrabajador((Trabajador) tienda.getTrabajadores().get(selection - 1));
                    break;
                }
            } catch (Exception e) {
                System.out.println("\nError de selección");
            }
        }

        return pedido;
    }

    public static Moto addMoto(Tienda tienda) {
        Moto moto = new Moto();
        System.out.println("\nAGREGAR MOTO");

        moto.setId((long) tienda.getVehiculos().size() + 1);
        System.out.print("Marca: ");
        moto.setMarca(scanner.nextLine());
        System.out.print("Modelo: ");
        moto.setModelo(scanner.nextLine());
        System.out.print("Patente: ");
        moto.setPatente(scanner.nextLine());
        while (true) {
            try {
                System.out.print("Año fabricación: ");
                moto.setAnoFabricacion(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("\nIngreso incorrecto\n");
            }
        }
        return moto;
    }

    public static Bicicleta addBicicleta(Tienda tienda) {
        Bicicleta bicicleta = new Bicicleta();
        System.out.println("\nAGREGAR BICICLETA");

        bicicleta.setId((long) tienda.getVehiculos().size() + 1);
        System.out.print("Marca: ");
        bicicleta.setMarca(scanner.nextLine());
        System.out.print("Modelo: ");
        bicicleta.setModelo(scanner.nextLine());
        while (true) {
            try {
                System.out.print("Dimensión ruedas: ");
                bicicleta.setDimensionesRuedas(Double.valueOf(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("\nIngreso incorrecto\n");
            }
        }
        return bicicleta;
    }

    public static Trabajador addTrabajador(Tienda tienda) {
        Trabajador trabajador = new Trabajador();
        System.out.println("\nAGREGAR TRABAJADOR");

        trabajador.setId((long) (tienda.getTrabajadores().size() + 1));
        System.out.print("Nombre: ");
        trabajador.setNombre(scanner.nextLine());
        System.out.print("RUN: ");
        trabajador.setRun(scanner.nextLine());
        System.out.print("Teléfono: ");
        trabajador.setTelefono(scanner.nextLine());

        int selection = 0;

        while (true) {
            try {
                mostrarVehiculos(tienda.getVehiculos());
                selection = Integer.parseInt(scanner.nextLine());
                if (selection > 0 && selection <= tienda.getVehiculos().size() + 1) {
                    trabajador.setVehiculo(tienda.getVehiculos().get(selection - 1));
                    break;
                }
            } catch (Exception e) {
                System.out.println("\nError de selección");
            }
        }

        return trabajador;
    }

    private static void mostrarVehiculos(List<Vehiculo> vehiculos) {
        AtomicInteger i = new AtomicInteger();
        StringBuilder stringBuilder = new StringBuilder("\nVEHÍCULOS:\n");
        vehiculos.forEach(vehiculo -> {
            i.getAndIncrement();
            stringBuilder.append(i + ". " + vehiculo + "\n");
        });
        stringBuilder.append("\nSelecciona un vehículo: ");
        System.out.print(stringBuilder);
    }

    private static void mostrarTrabajadores(List<Persona> trabajadores) {
        AtomicInteger i = new AtomicInteger();
        StringBuilder stringBuilder = new StringBuilder("\nTRABAJADORES:\n");
        trabajadores.forEach(trabajador -> {
            i.getAndIncrement();
            stringBuilder.append(i + ". " + trabajador + "\n");
        });
        stringBuilder.append("\nSelecciona un trabajdor: ");
        System.out.print(stringBuilder);
    }
}
