import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int n=0;
        do {
            System.out.println("Selecciona una opción");
            switch (scan.nextInt()){
                case 1 -> listarTareas();
                case 2 -> cambiarEstado();
                case 3 -> editarTarea();
                case 4 -> borrarTarea();
                case 5 -> busqueda();

                        /*Crear una Nueva Tarea
                        Cambiar de Estado de una Tarea
                        Editar una Tarea (Solo Título, Descripción o Responsable)
                        Borrar una Tarea
                        Búsqueda por: Usuario o Coincidencia de Nombre.
                        */
            }
        }while (n!=0);
    }

    public void listarTareas(){

    }

    public void cambiarEstado(){

    }

    public void editarTarea(){

    }

    public void borrarTarea(){

    }

    public void busqueda(){

    }

}
