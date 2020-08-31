import java.util.Scanner;

public class main {
    static Scanner scan = new Scanner (System.in);
    static int n;
    public static void main(String[] args) {
        do {
            System.out.println("Selecciona una opción:\n1- Listar tarea\n2.- Cambiar estado\n3.- Editar tarea\n4.- Borrar tarea\n5.- Búsqueda\n0.- Salir.");
            n=scan.nextInt();
            switch (n){
                case 1 -> listarTareas();
                case 2 -> cambiarEstado();
                case 3 -> editarTarea();
                case 4 -> borrarTarea();
                case 5 -> busqueda();
                case 0 -> System.exit(0);
                default -> System.out.println("Selección errónea");
            }
        }while (n!=0);
    }

    //Funciones menú principal
    public static void listarTareas(){

    }

    public static void cambiarEstado(){

    }

    public static void editarTarea(){
        //Editar una Tarea (Solo Título, Descripción o Responsable)
        do{
            System.out.println("¿Qué quieres editar?\n1.- Título\n2.- Descripción\n3.- Responsable\n0.- Salir");
            n=scan.nextInt();
            switch (n){
                case 1 -> editTitulo();
                case 2 -> editDescripcion();
                case 3 -> editResponsable();
                case 0 -> System.exit(0);
                default -> System.out.println("Selección errónea");
            }
        }while (n!=0);
    }

    public static void borrarTarea(){

    }

    public static void busqueda(){
        //Búsqueda por: Usuario o Coincidencia de Nombre.
    }


    //Funciones editar
    public static void editTitulo(){}
    public static void editDescripcion(){}
    public static void editResponsable(){}

}
