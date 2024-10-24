import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //instancio ControlDeTareas y como habras nnotado en su contructor esta el metodo optenerTareasArchivoTxt
        //el cual sirve para poder cargar la lista si ya existe
        ControlTareas controlTareas = new ControlTareas();

        boolean hacerTarea = false;

        while (!hacerTarea) {
            System.out.println("Tareas");
            System.out.println("1 Mostar Tareas");
            System.out.println("2 Guardar Tarea");
            System.out.println("3 Completar Tarea");
            System.out.println("4 Eliminar Tarea");
            System.out.println("5 Mostar Tareas Pendientes");
            System.out.println("6 Dejar de Hacer Tareas");


            // Leer la entrada como string
            String entrada = sc.nextLine();

            // Verificar si la entrada es numérica
            if (esNumero(entrada)) {
                int opcion = Integer.parseInt(entrada);  // Convertir a número

                if (opcion == 1) {
                    System.out.println("Lista de Tareas");
                    controlTareas.listarTareas();
                } else if (opcion == 2) {
                    System.out.println("Guardar Tarea");
                    String resumenTarea = sc.nextLine();
                    try {
                        controlTareas.agregarTarea(resumenTarea);
                    } catch (Exception e) {
                        System.out.println("Error al guardar tarea: " + e.getMessage());
                    }
                } else if (opcion == 3) {
                    System.out.println("Completar Tarea");
                    System.out.println("Ingrese el índice de la tarea a completar:");
                    String completarTareaInput = sc.nextLine();

                    if (esNumero(completarTareaInput)) {
                        int completarTarea = Integer.parseInt(completarTareaInput);
                        try {
                            controlTareas.tareaCompletada(completarTarea);
                        } catch (Exception e) {
                            System.out.println("Error al completar tarea: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Debe ingresar un número válido.");
                    }
                } else if (opcion == 4) {
                    System.out.println("Eliminar Tarea");
                    System.out.println("Ingrese el índice de la tarea a eliminar:");
                    String eliminarTareaInput = sc.nextLine();

                    if (esNumero(eliminarTareaInput)) {
                        int eliminarTarea = Integer.parseInt(eliminarTareaInput);
                        try {
                            controlTareas.eliminarTarea(eliminarTarea);
                        } catch (Exception e) {
                            System.out.println("Error al eliminar tarea: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Debe ingresar un número válido.");
                    }
                } else if (opcion == 5) {
                    System.out.println("Tareas Pendientes:");
                    controlTareas.tareasPendientes();
                } else if (opcion == 6) {
                    hacerTarea = true;
                    System.out.println("Terminando...");
                } else {
                    System.out.println("Por favor, seleccione un número entre 1 y 6.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número.");
            }
        }

        sc.close();
    }

    // Método para verificar si una cadena es numérica
    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}