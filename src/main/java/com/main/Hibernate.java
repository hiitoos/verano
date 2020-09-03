package com.main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public Hibernate() {
        this.emf = Persistence.createEntityManagerFactory("veranoPersistence");
        this.em = this.emf.createEntityManager();
    }

    public static void createTarea(Tareas newT) {
        em.getTransaction().begin();
        em.persist(newT);
        em.getTransaction().commit();
    }

    public static void showT() {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM Tareas").getResultList();
        for(int i=0; i<tareas.size(); i++){
            System.out.println("ID: " + tareas.get(i).getId());
            System.out.println("Titulo: " + tareas.get(i).getTitulo());
            System.out.println("Descripcion: " + tareas.get(i).getDescripcion());
            System.out.println("Fecha Creacion: " + tareas.get(i).getFechaCreacion());
            System.out.println("Responsable: " + tareas.get(i).getResponsable());
            System.out.println("Estado: " + tareas.get(i).getEstado());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public static List<Tareas> getTearea(){
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM Tareas").getResultList();
        return tareas;
    }

    public static void showUser() {
        List<Usuarios> users = (List<Usuarios>) em.createQuery("FROM Usuarios").getResultList();
        for(int i=0; i<users.size(); i++){
            System.out.println("ID: " + users.get(i).getId());
            System.out.println("Nombre: " + users.get(i).getNombre());
            System.out.println("Apellidos: " + users.get(i).getAppellidos());
            System.out.println("Email: " + users.get(i).getEmail());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public static void updateTarea(Tareas tarea) {
        em.getTransaction().begin();
        em.merge(tarea);
        em.getTransaction().commit();
        System.out.println("¡¡Tarea actualizada!!");
    }

    public static void deleteTarea(int id) {
        Tareas tarea =  em.find(Tareas.class, id);
        em.getTransaction().begin();
        em.remove(tarea);
        em.getTransaction().commit();
        System.out.println("¡¡Tarea eliminada!!");
    }

    public static void readEstado() {
        List<Estados> estados = (List<Estados>) em.createQuery("FROM Estados").getResultList();
        for(int i=0; i<estados.size(); i++){
            System.out.println("ID: " + estados.get(i).getId());
            System.out.println("Nombre: " + estados.get(i).getNombre());
            System.out.println("Descripcion: " + estados.get(i).getDescripcion());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public static void buscarUsuario(String usuario) {
        List id = em.createQuery("select id FROM Usuarios WHERE nombre LIKE '%"+usuario+"%'").getResultList();
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM Tareas WHERE responsable = " + id.get(0)).getResultList();
        for(int i=0; i<tareas.size(); i++){
            System.out.println("ID: " + tareas.get(i).getId());
            System.out.println("Titulo: " + tareas.get(i).getTitulo());
            System.out.println("Descripcion: " + tareas.get(i).getDescripcion());
            System.out.println("Fecha Creacion: " + tareas.get(i).getFechaCreacion());
            System.out.println("Responsable: " + tareas.get(i).getResponsable());
            System.out.println("Estado: " + tareas.get(i).getEstado());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public static void close() {
        emf.close();
        em.close();
    }
}