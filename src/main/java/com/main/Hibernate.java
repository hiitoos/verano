package com.main;

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

    public static List<Tareas> showT() {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM tareas").getResultList();
        return tareas;
    }

    public static List<Usuarios> showUser() {
        List<Usuarios> users = (List<Usuarios>) em.createQuery("FROM usuarios").getResultList();
        return users;
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

    public static List<Estados> readEstado() {
        List<Estados> estados = (List<Estados>) em.createQuery("FROM estados").getResultList();
        return estados;
    }

    public static List<Tareas> buscarUsuario(String usuario) {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM tareas WHERE (responsable LIKE '%"+usuario+"%')").getResultList();
        return tareas;
    }

    public void close() {
        this.emf.close();
        this.em.close();
    }
}