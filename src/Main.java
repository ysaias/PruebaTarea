import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlTareas controlTareas = new ControlTareas();

        boolean hacerTarea = false;

        while (!hacerTarea) {
            System.out.println("Agenda Tarea");
            System.out.println("1 Mostar Tareas");
            System.out.println("2 Guardar Tarea");
            System.out.println("3 Completar Tarea");
            System.out.println("4 Elimniar Tarea");
            System.out.println("5 Mostar Tareas Pendientes");
            System.out.println("6 Dejar de Hacer Tareas");

            int opcion = sc.nextInt();
            sc.nextLine();

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

                int completarTarea = sc.nextInt();
                controlTareas.tareaCompletada(completarTarea);

            } else if (opcion == 4) {
                System.out.println("Eliminar Tarea");
                System.out.println("Ingrese el índice de la tarea a eliminar:");

                int eliminarTarea = sc.nextInt();
                controlTareas.eliminarTarea(eliminarTarea);

            } else if (opcion == 5) {
                System.out.println("Tareas Pendientes:");
                controlTareas.tareasPendientes();
            } else if (opcion == 6) {
                hacerTarea = true;
            }
        }


    }
}