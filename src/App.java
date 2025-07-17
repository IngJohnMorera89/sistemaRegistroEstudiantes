import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    mostrarDatosEstudiante();
                    break;

                case 3:
                    calcularPromedio();
                    break;
                case 4:
                    aprobarEstudiante();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 0 );

        // Cerrar el escáner al finalizar
        scanner.close();
        System.out.println("Gracias por usar el sistema de registro de estudiantes.");

    }

    public static void mostrarMenu() {
        System.out.print("""


                ---Bienvenido a su Sistema de Registro de Estudiantes---
                ______________________________________________________

                "Inicie con la Opción 1 para registrar los datos del estudiante"

                Luego seleccione la opción que desee:


                Selecciones una opción:

                1. Registar datos del estudiante
                2. Mostrar datos del estudiante
                3. Calcular promedio de notas.
                4. Resultado Final del estudiante
                0. Salir

                """);
    }

    static String nombre; // Variable para almacenar el nombre del estudiante
    static double nota1, nota2, nota3; // Variables para almacenar las notas del estudiante

    public static void registrarEstudiante() {

        // Implementación para registrar datos del estudiante

        System.out.println("Ingrese el nombre del Estudiante:");
        Scanner scanner = new Scanner(System.in);
        nombre = scanner.nextLine();
        while (!validarNombre(nombre)) {
            System.out.println("Ingrese un nombre válido:");
            nombre = scanner.nextLine();
        }
        System.out.println("Ingrese tres (3) notas del Estudiante:");

        nota1 = scanner.nextDouble();
        while (!validarNotas(nota1)) {
            System.out.println("Ingrese una nota válida (entre 0 y 5):");
            nota1 = scanner.nextDouble();
        }
        nota2 = scanner.nextDouble();
        while (!validarNotas(nota2)) {
            System.out.println("Ingrese una nota válida (entre 0 y 5):");
            nota2 = scanner.nextDouble();
        }
        nota3 = scanner.nextDouble();
        while (!validarNotas(nota3)) {
            System.out.println("Ingrese una nota válida (entre 0 y 5):");
            nota3 = scanner.nextDouble();
        }

        System.out.println("Los datos del estudiante han sido registrados correctamente.");
        System.out.println("____________________________________________________");

    }

    public static void mostrarDatosEstudiante() {
        // Implementación para mostrar datos del estudiante
        System.out.println("""
                Los datos del estudiante son:  
                Nombre: %s
                Nota 1: %.2f
                Nota 2: %.2f
                Nota 3: %.2f
                _____________________________________________________
                """.formatted(nombre, nota1, nota2, nota3));

    }

    public static double calcularPromedio() {
        // Implementación para calcular el promedio de las notas
        double Promedio = (nota1 + nota2 + nota3) / 3;
        System.out.printf("El promedio de las notas es: %.2f\n", Promedio);
        System.out.println("____________________________________________________");
        return Promedio;

    }

    public static boolean validarNotas(double nota1) {
        // Implementación para validar que las notas estén entre 0 y 5
        if (nota1 >= 0 && nota1 <= 5) {
            return true;
        }
        System.out.println("Nota invválida: ");
        return false;

    }

    public static boolean validarNombre(String nombre) {
        // Implementación para validar que el nombre no esté vacío
        if (nombre != null && !nombre.trim().isEmpty()) {
            return true;
        }
        System.out.println("Nombre inválido: ");
        return false;
    }

    public static void aprobarEstudiante() {
        // Implementación para aprobar al estudiante si el promedio es mayor o igual a 3
        double promedio = calcularPromedio();
        if (promedio >= 3) {
            System.out.println("El estudiante ha sido aprobado.");
            System.out.println("____________________________________________________");
        } else {
            System.out.println("El estudiante ha reprobado.");
            System.out.println("____________________________________________________");
            
        }
    }

}
