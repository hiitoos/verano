package com.main;

import com.main.application.domain.entities.Tarea;
import com.main.application.repositories.Hibernate;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanInt = new Scanner (System.in);
    static Scanner scanSt = new Scanner (System.in);
    static int id;
    static int n;
    static List<Tarea> tareas;
    static Tarea tareaActu = new Tarea();

    public static void main(String[] args) {
        Hibernate hb = new Hibernate();
        menu();
    }

    public static void menu(){
        do {
            System.out.println("Selecciona una opción:\n1.- Listar tarea\n2.- Crear tarea\n3.- Cambiar estado\n4.- Editar tarea\n5.- Borrar tarea\n6.- Búsqueda\n0.- Salir.");
            n= scanInt.nextInt();
            switch (n){
                case 1 -> Hibernate.showT();
                case 2 -> crearTarea();
                case 3 -> editarTarea(1);
                case 4 -> editarTarea(2);
                case 5 -> borrarTarea();
                case 6 -> busqueda();
                case 0 -> {
                    Hibernate.close();
                    System.exit(0);
                }
                default -> System.out.println("Selección errónea");
            }
        }while (n!=0);
    }

    public static void crearTarea(){
        Tarea newTarea = new Tarea();
        System.out.println("Introduce título");
        newTarea.setTitulo(scanSt.nextLine());
        System.out.println("Introduce descripcion");
        newTarea.setDescripcion(scanSt.nextLine());
        System.out.println("Introduce estado");
        Hibernate.readEstado();
        newTarea.setEstado(scanInt.nextInt());
        System.out.println("Introduce id responsable");
        Hibernate.showUser();
        newTarea.setResponsable(scanInt.nextInt());
        System.out.println("Introduce fecha de creacion(AAAA-MM-DD)");
        newTarea.setFechaCreacion(Date.valueOf(scanSt.nextLine()));
        Hibernate.createUpdateTarea(newTarea);
    }

    public static void editarTarea(int valor){
        Hibernate.showT();
        tareas = Hibernate.getTarea();
        System.out.println("Introduce el ID de la tarea");
        id = scanInt.nextInt();
        if (valor==1){
            Hibernate.readEstado();
            System.out.println("Introduce el nuevo estado");
            int estado = scanInt.nextInt();
            for (int i=0; i<tareas.size(); i++){
                if (tareas.get(i).getId() == id){
                    tareaActu.setId(tareas.get(i).getId());
                    tareaActu.setTitulo(tareas.get(i).getTitulo());
                    tareaActu.setDescripcion(tareas.get(i).getDescripcion());
                    tareaActu.setResponsable(tareas.get(i).getResponsable());
                    tareaActu.setFechaCreacion(tareas.get(i).getFechaCreacion());
                    tareaActu.setEstado(estado);
                    Hibernate.createUpdateTarea(tareaActu);
                }
            }
        }
        else {
            do {
                System.out.println("¿Qué quieres editar?\n1.- Título\n2.- Descripción\n3.- Responsable\n0.- Atras");
                n = scanInt.nextInt();
                switch (n) {
                    case 1 -> edit(1);
                    case 2 -> edit(2);
                    case 3 -> edit(3);
                    case 0 -> menu();
                    default -> System.out.println("Selección errónea");
                }
            } while (n != 0);
        }
    }

    public static void edit(int valor){
        int user=0;
        String nuevoValor="";
        if(valor!=3) {
            if (valor == 1)
                System.out.println("Introduce el nuevo titulo");
            if (valor == 2)
                System.out.println("Introduce la nueva descripcion");
            nuevoValor = scanSt.nextLine();
        }
        if(valor==3) {
            System.out.println("Introduce el nuevo responsable");
            Hibernate.showUser();
            user = scanInt.nextInt();
        }
        for (int i=0; i<tareas.size(); i++){
            if (tareas.get(i).getId() == id){
                tareaActu.setId(tareas.get(i).getId());
                tareaActu.setTitulo(tareas.get(i).getTitulo());
                tareaActu.setDescripcion(tareas.get(i).getDescripcion());
                tareaActu.setResponsable(tareas.get(i).getResponsable());
                tareaActu.setFechaCreacion(tareas.get(i).getFechaCreacion());
                tareaActu.setEstado(tareas.get(i).getEstado());
                if (valor==1)
                    tareaActu.setTitulo(nuevoValor);
                if (valor==2)
                    tareaActu.setDescripcion(nuevoValor);
                if (valor==3)
                    tareaActu.setResponsable(user);
                Hibernate.createUpdateTarea(tareaActu);
            }
        }
        menu();
    }

    public static void busqueda(){
        System.out.println("Introduce el nombre");
        Hibernate.buscarUsuario(scanSt.nextLine());
    }
    
    public static void borrarTarea(){
        System.out.println("Introduce el ID de la tarea a borrar");
        Hibernate.showT();
        Hibernate.deleteTarea(scanInt.nextInt());
    }
}
