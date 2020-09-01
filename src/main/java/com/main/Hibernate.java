package com.main;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public Hibernate() {
        this.emf = Persistence.createEntityManagerFactory("TaskListPersistence");
        this.em = this.emf.createEntityManager();
    }

    public static void createTarea(Tareas newT) {
        em.getTransaction().begin();
        em.persist(newT);
        em.getTransaction().commit();
    }

    public static void showT() {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM Tareas").getResultList();
        Iterator iter = tareas.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }

    public static List<Tareas> getTearea(){
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM Tareas").getResultList();
        return tareas;
    }

    public static void showUser() {
        List<Usuarios> users = (List<Usuarios>) em.createQuery("FROM Usuarios").getResultList();
        Iterator iter = users.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }

    public static void updateTarea(Tareas tarea) {
        em.getTransaction().begin();
        em.merge(tarea);
        em.getTransaction().commit();
    }

    public static void deleteTarea(int id) {
        Tareas tarea =  em.find(Tareas.class, id);
        em.getTransaction().begin();
        em.remove(tarea);
        em.getTransaction().commit();
    }

    public static void readEstado() {
        List<Estados> estados = (List<Estados>) em.createQuery("FROM Estados").getResultList();
        Iterator iter = estados.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }

    public static void buscarUsuario(String usuario) {
        List id = em.createQuery("select id FROM Usuarios WHERE nombre LIKE '%"+usuario+"%'").getResultList();
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM Tareas WHERE responsable = " + id.get(0)).getResultList();
        Iterator iter = tareas.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }

    public static void close() {
        emf.close();
        em.close();
    }
}