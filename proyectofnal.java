import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class proyectofnal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear la lista de empresas y universidades
        List<String> empresas = new ArrayList<>();
        empresas.add("NTTDATA");
        empresas.add("BCP");
        empresas.add("INTERBANK");
        empresas.add("BEMBOS");
        empresas.add("FACEBOOK");
        empresas.add("APPLE");

        List<String> universidades = new ArrayList<>();
        universidades.add("UPC");
        universidades.add("PUCP");
        universidades.add("ULIMA");
        universidades.add("CAYETANO");
        universidades.add("USIL");
        universidades.add("UP");

        // Verificar si hay problemas con el equipo
        System.out.print("¿Cuál es el problema con su equipo? (Hardware, Software, No lo reconozco): ");
        String problemaEquipo = scanner.nextLine();
        double precio = 0;

        if (problemaEquipo.equalsIgnoreCase("Hardware")) {
            precio = 100;
            System.out.println("El problema saldría en $" + precio);
        } else if (problemaEquipo.equalsIgnoreCase("Software")) {
            precio = 100; // Precio para problemas de software
            System.out.println("El problema saldría en $" + precio);
        } else if (problemaEquipo.equalsIgnoreCase("No lo reconozco")) {
            precio = 125;
            System.out.println("No hay problema. El precio sería un total de: $" + precio);
        } else {
            System.out.println("Respuesta inválida.");
            scanner.close();
            return;
        }

        // Solicitar comentario sobre el problema
        System.out.println("Por favor, comente sobre el problema:");
        String comentario = scanner.nextLine();
        System.out.println("Gracias por su comentario: " + comentario);

        // Solicitar al usuario que ingrese su estado (empleado, universitario)
        System.out.print("¿Es usted empleado o universitario? ");
        String estado = scanner.nextLine();

        // Verificar el estado ingresado por el usuario
        if (estado.equalsIgnoreCase("empleado")) {
            verificarEmpleado(scanner, empresas, precio);
        } else if (estado.equalsIgnoreCase("universitario")) {
            verificarUniversitario(scanner, universidades, precio);
        } else {
            // Si no es ni empleado ni universitario, se le cobra el precio estándar
            System.out.println("Usted no es ni empleado ni universitario.");
            System.out.println("El precio es: $" + precio);
        }

        scanner.close();
    }

    // Método para verificar si es empleado y aplicar descuento si corresponde
    private static void verificarEmpleado(Scanner scanner, List<String> empresas, double precio) {
        System.out.print("Ingrese el nombre de la empresa en la que trabaja: ");
        String empresa = scanner.nextLine();

        // Verificar si la empresa está en la lista
        if (empresas.contains(empresa.toUpperCase())) {
            System.out.print("¿Cuántos servicios de mantenimiento ha requerido anteriormente? (1 a 10): ");
            int numeroServicios = scanner.nextInt();

            double descuento;
            if (numeroServicios >= 1 && numeroServicios <= 3) {
                descuento = precio * 0.2; // Descuento del 20% para 1 a 3 servicios
            } else if (numeroServicios >= 4 && numeroServicios <= 6) {
                descuento = precio * 0.25; // Descuento del 25% para 4 a 6 servicios
            } else if (numeroServicios >= 7 && numeroServicios <= 10) {
                descuento = precio * 0.3; // Descuento del 30% para 7 a 10 servicios
            } else {
                System.out.println("Número de servicios inválido.");
                return;
            }

            double precioConDescuento = precio - descuento;
            System.out.println("Usted es un empleado en " + empresa + ". ¡Tiene descuento!");
            System.out.println("El precio con descuento es: $" + precioConDescuento);
        } else {
            System.out.println("Usted es un empleado en " + empresa + ". Lamentablemente no cuenta con descuento.");
            System.out.println("El precio es: $" + precio);
        }
    }

    // Método para verificar si es universitario y aplicar descuento si corresponde
    private static void verificarUniversitario(Scanner scanner, List<String> universidades, double precio) {
        System.out.print("Ingrese el nombre de su universidad: ");
        String universidad = scanner.nextLine();

        // Verificar si la universidad está en la lista
        if (universidades.contains(universidad.toUpperCase())) {
            double descuento = 0;
            double precioConDescuento = 0;
            boolean puestoValido = false;

            // Preguntar en qué puesto está el estudiante y aplicar descuento correspondiente
            while (!puestoValido) {
                System.out.println("¿En qué puesto está usted? (1er puesto, Tercio Superior, Otro): ");
                String puesto = scanner.nextLine().toLowerCase();

                switch (puesto) {
                    case "1er puesto":
                        descuento = precio; // El primer puesto es gratis
                        precioConDescuento = 0;
                        System.out.println("¡Felicidades! Como está en el primer puesto, el servicio es gratis.");
                        puestoValido = true;
                        break;
                    case "tercio superior":
                        descuento = precio * 0.5; // Descuento del 50% para tercio superior
                        precioConDescuento = precio - descuento;
                        System.out.println("¡Bien hecho! Como está en el tercio superior, tiene un descuento del 50%.");
                        puestoValido = true;
                        break;
                    case "otro":
                        descuento = precio * 0.2; // Descuento del 20% para otros casos
                        precioConDescuento = precio - descuento;
                        System.out.println("UNICAMENTE CUENTA CON EL 20% QUE LE BRINDA LA UNIVERSIDAD.");
                        puestoValido = true;
                        break;
                    default:
                        System.out.println("Respuesta inválida. Por favor, ingrese un puesto válido.");
                        break;
                }
            }

            System.out.println("El precio con descuento en total es de: $" + precioConDescuento);
        } else {
            System.out.println("Le informamos que su universidad " + universidad + " no cuenta con convenio.");
            System.out.println("El precio es: $" + precio);
        }
    }
}

