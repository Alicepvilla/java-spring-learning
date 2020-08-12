package tienda;

import tienda.model.Tienda;

import java.util.Scanner;

import static tienda.service.TiendaService.*;


public class PrincipalClass {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run(new Tienda());
    }

    private static void run(Tienda tienda) {
        boolean run = true;

        StringBuilder stringBuilder = new StringBuilder("\nMENÚ\n");
        stringBuilder.append("1. Agregar vendedor.\n");
        stringBuilder.append("2. Agregar moto.\n");
        stringBuilder.append("3. Agregar bicicleta.\n");
        stringBuilder.append("4. Registrar pedido.\n");
        stringBuilder.append("5. Calcular total ganado.\n");
        stringBuilder.append("6. Salir.\n");
        stringBuilder.append("\nSelecciona una opción: ");

        while (run) {
            System.out.print(stringBuilder);
            try {
                int selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        tienda.getTrabajadores().add(addTrabajador(tienda));
                        break;
                    case 2:
                        tienda.getVehiculos().add(addMoto(tienda));
                        break;
                    case 3:
                        tienda.getVehiculos().add(addBicicleta(tienda));
                        break;
                    case 4:
                        tienda.getRegistros().add(addPedido(tienda));
                        break;
                    case 5:
                        calcularTotalGanado(tienda);
                        break;
                    case 6:
                        run = false;
                        break;
                    default:
                        System.err.print("\nERROR\nPresiona enter...\n");
                        scanner.nextLine();
                }
            } catch (Exception e) {
                System.err.print("\nERROR\nPresiona enter...\n");
                scanner.nextLine();
            }
        }
        System.out.println("\n¡ADIÓS!");
    }
}
