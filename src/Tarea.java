

public class Tarea {

    // Declaro dos variables para trabajar con la tareas
    private String tarea; // Aqui es el resumen o descripcion de la tarea
    private String completada; // Aqui se indica si estará pendiente o completa la tarea

    //Constuctor vacio. Solo lo utilizo para instanciar la clase en otra parte
    public Tarea() {

    }

    //Los getter y setter me serviran para acceder y modificar sus atributos, osea a las variables
    public String getTarea() {

        return tarea;
    }

    public void setTarea(String tarea) {

        this.tarea = tarea;
    }

    public String getCompletada() {

        return completada;
    }

    public void setCompletada(String completada) {

        this.completada = completada;
    }
}
