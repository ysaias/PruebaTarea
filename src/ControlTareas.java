import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControlTareas {

    List<Tarea> tareas;
    //Esto es la declaracion del nombre del archivo que alamcenará las tareas
    private static final String ARCHIVO = "tareas.txt";

    public ControlTareas() {
        this.tareas = new ArrayList<>(); // Instancio una arrayList de Taréa
        optenerTareasArchivoTxt(); // Carga las tareas guardadas en el archivo
    }

    public void agregarTarea(String resumen) {
        Tarea tarea = new Tarea(); //Intancio la clase Tarea
        tarea.setTarea(resumen); //accedo al atributo Tarea y le asigno una tarea
        tarea.setCompletada("Pendiente"); //accedo al atributo Completada y le asigno Pendiente
        tareas.add(tarea); //lo adisiono a la lista

        //Guardo la tarea en el archivo con el modo append "true" para no sobrescribir lo que ya tiene guardado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {

            writer.write(tarea.getTarea() + ";" + tarea.getCompletada());//Se guarda tarea y el estado
            writer.newLine();//se crea una nueva linea para que este listo para otra tarea
        } catch (IOException e) {
            //Muestra si hay un error
            System.out.println("Error al guardar tareas: " + e.getMessage());
        }
        //Esto era para hacer prueba de que estaba bien
        //System.out.println("Tarea agregada correctamente.");
    }

    public void listarTareas() {
        //Si está vacio muestra un mensaje
        if (tareas.isEmpty()) {
            System.out.println("Lista de tareas vacia");
        } else {
            //Si no está vacio recorre la lista e imprime la tarea y su estado
            for (int i = 0; i < tareas.size(); i++) {
                Tarea tarea = tareas.get(i);
                System.out.println(i + ": " + tarea.getTarea() + " " + tarea.getCompletada());
            }
        }
    }

    public void tareaCompletada(int index) {
        //verifico que el inidice exista
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).setCompletada("Completada"); //Se marca como completada
            guardarTarea(); // El archivo se actualiza
        } else {
            System.out.println("Tarea Completada Invalido");
        }
    }

    public void tareasPendientes() {
        //Si está vacio muestra un mensaje
        if (tareas.isEmpty()) {
            System.out.println("No tiene tareas Pendientes");
        }
        //Si no está vacio recorre la lista e imprime la tarea y solo con el estado pendiente
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            //Aqui verifica si su está en pendiente para ser impreso
            if (tarea.getCompletada().equals("Pendiente")) {
                System.out.println(i + ": " + tarea.getTarea() + " " + tarea.getCompletada());
            }
        }
    }

    public void eliminarTarea(int index) {
        //verifico que el inidice exista
        if (index >= 0 && index < tareas.size()) {
            tareas.remove(index); // se elimina la tarea de la lista
            guardarTarea(); // se reescribe el archivo así queda actualizada
        } else {
            System.out.println("Indice no valido");
        }
    }


    //guardar tarea en un archivo txt
    //Este método asegura que los cambios como eliminar o completar tareas persistan en el archivo
    public void guardarTarea() {

        //Reescribe el archivo de texto con todas las tareas actuales de la lista
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Tarea tarea : tareas) {

                writer.write(tarea.getTarea() + ";" + tarea.getCompletada());//Se guarda cada tarea
                writer.newLine(); //se crea una nueva linea para que este listo para otra tarea
            }
            // Era para controlar que salió bien
            //System.out.println("Tarea guardada correctamente ");
        } catch (IOException e) {
            System.out.println("Error guardar tareas: " + e.getMessage());
        }

    }


    //optiene las tareas desde el archivo txt
    private void optenerTareasArchivoTxt() {
        //Se obtiene el archivo
        File archivo = new File(ARCHIVO);
        if (archivo.exists()) {
            //Lee el archivo de texto guardado
            try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
                //divide cada línea de la tarea y su estado separados por un ;
                String leerLinea;
                while ((leerLinea = leer.readLine()) != null) {
                    String[] partes = leerLinea.split(";");
                    if (partes.length == 2) {
                        //Capturo la tarea (resumen o descripcion)
                        String resumen = partes[0];
                        //Capturo el estado
                        String completado = partes[1];
                        //Creo el objeto tarea
                        Tarea tarea = new Tarea();
                        //agrego el resumen de la tarea
                        tarea.setTarea(resumen);
                        //agrego el estado
                        tarea.setCompletada(completado);
                        //lo adiciono a la lista tareas
                        tareas.add(tarea);
                    }

                }
                System.out.println("Listado de tareas correctamente");
            } catch (IOException e) {
                System.out.println("Error en Cargar Tareas " + e.getMessage());
            }
        } else {
            System.out.println("Archivo tareas no encontrado");
        }
    }

}
