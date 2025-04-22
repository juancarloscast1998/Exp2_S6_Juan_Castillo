
public class TeatroMoro {
    static int totalEntradasVendidas = 0;
    static double totalIngresos = 0;
    int capacidadSala = 40;
    int entradasDisponibles = capacidadSala;
    double precioEntrada = 5500.0;
    int entradasReservadas = 0;
    double costoTotal = 0;
    String ubicacionAsiento = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeatroMoro teatro = new TeatroMoro();

        while (true) {
             System.out.println("//////////////////////////////////////");
             System.out.println("                                      ");
             System.out.println("======BIENVENIDO AL TEATRO MORO=======");
             System.out.println("                                     ");
             System.out.println("//////////////////////////////////////");
             System.out.println("                                     ");
             System.out.println("Para efectuar su compra de manera exitosa");
             System.out.println("                                     ");
             System.out.println("Recuerde, primero:");
             System.out.println("                                     ");
             System.out.println(" Reservar --> Comprar --> Finalizar Compra");
             System.out.println("                                     ");
             System.out.println("--Seleccione una opcion, por favor.--");
             System.out.println("                                      ");
             System.out.println("                                      ");
             System.out.println("//----- Menu Principal -----//");
             System.out.println("                                      ");
             System.out.println("                                     ");
                 System.out.println("1. Reservar entradas");
                 System.out.println("2. Comprar entradas");
                 System.out.println("3. Modificar una venta existente");
                 System.out.println("4. Finalizar Compra");
                 System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    teatro.reservarEntradas(scanner);
                    break;
                case 2:
                    teatro.comprarEntradas(scanner);
                    break;
                case 3:
                    teatro.modificarVenta(scanner);
                    break;
                case 4:
                    teatro.imprimirBoleta(scanner);
                    break;
                case 5:
                    System.out.println("Esperamos con ansias su vuelta al Teatro Moro, Muchas gracias!!");
                    return;
                default:
                    System.out.println("Opcion erronea, por favor intente con una de las opciones disponibles.");
            }
        }
    }

    public void reservarEntradas(Scanner scanner) {
        if (entradasDisponibles > 0) {
            System.out.print("¿Cuantas entradas desea reservar?: ");
            int cantidad = scanner.nextInt();

            if (cantidad <= entradasDisponibles) {
                entradasReservadas = cantidad;
                entradasDisponibles -= cantidad;
                System.out.println("Entradas reservadas exitosamente.");
                System.out.println("[DEBUG] Reservadas: " + entradasReservadas);
                System.out.println("[DEBUG] Disponibles: " + entradasDisponibles);
            } else {
                System.out.println("No hay suficientes entradas disponibles.");
            }
        } else {
            System.out.println("No hay entradas disponibles.");
        }
    }

    public void comprarEntradas(Scanner scanner) {
        if (entradasReservadas > 0) {
            System.out.print("Ingrese la cantidad de entradas a comprar: ");
            int cantidad = scanner.nextInt();

            if (cantidad == entradasReservadas) {
                costoTotal = cantidad * precioEntrada;
                totalEntradasVendidas += cantidad;
                totalIngresos += costoTotal;
                entradasReservadas = 0;
                System.out.println("Compra realizada con éxito.");
                System.out.println("[DEBUG] Costo total: $" + costoTotal);
                System.out.println("[DEBUG] Total vendidas: " + totalEntradasVendidas);
            } else {
                System.out.println("La cantidad no coincide con las reservadas.");
            }
        } else {
            System.out.println("No hay entradas reservadas.");
        }
    }

    public void modificarVenta(Scanner scanner) {
        System.out.print("Ingrese la cantidad de entradas que desea modificar: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= totalEntradasVendidas) {
            totalEntradasVendidas -= cantidad;
            entradasDisponibles += cantidad;
            System.out.println("Venta modificada con éxito.");
            System.out.println("[DEBUG] Vendidas después de modificación: " + totalEntradasVendidas);
            System.out.println("[DEBUG] Disponibles ahora: " + entradasDisponibles);
        } else {
            System.out.println("No puede modificar más entradas de las que se han vendido.");
        }
    }

    public void imprimirBoleta(Scanner scanner) {
        if (totalEntradasVendidas > 0) {
            System.out.print("Ingrese el número de entradas compradas: ");
            int cantidad = scanner.nextInt();

            if (cantidad <= totalEntradasVendidas) {
                double total = cantidad * precioEntrada;
                System.out.println("\n----- Boleta de compra -----");
                System.out.println("Entradas: " + cantidad);
                System.out.println("Precio unitario: $" + precioEntrada);
                System.out.println("Total a pagar: $" + total);
                System.out.println("¡Gracias por su compra en el Teatro Moro!");
                System.out.println("¡¡Disfruta tu funcion!!");
            } else {
                System.out.println("Ha ingresado más entradas de las que ha comprado.");
            }
        } else {
            System.out.println("No se han realizado compras aún.");
        }
    }
}