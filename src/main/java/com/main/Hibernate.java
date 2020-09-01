package com.main;

import java.text.ParseException;
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

    public void createTarea(String titulo, String descripcion, String estado, String responsable, java.sql.Date fecha) throws ParseException {
        Tareas nuevaTarea = new Tareas(titulo, descripcion, estado, responsable, fecha);
        this.em.getTransaction().begin();
        this.em.persist(nuevaTarea);
        this.em.getTransaction().commit();
    }

    public void createTarea(Tareas newT) {
        this.em.getTransaction().begin();
        this.em.persist(newT);
        this.em.getTransaction().commit();
    }

    public List<Tareas> showT() {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM tareas").getResultList();
        return tareas;
    }

    public void updateTarea(Tareas tarea) {
        this.em.getTransaction().begin();
        this.em.merge(tarea);
        this.em.getTransaction().commit();
    }

    public void deleteTarea(int id) {
        Tareas tarea =  em.find(Tareas.class, id);
        this.em.getTransaction().begin();
        this.em.remove(tarea);
        this.em.getTransaction().commit();
    }

    public List<Estados> readEstado() {
        List<Estados> estados = (List<Estados>) em.createQuery("FROM estados").getResultList();
        return estados;
    }

    public List<Tareas> buscarNombre(String target) {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM tareas WHERE (responsable LIKE '%"+target+"%')").getResultList();
        return tareas;
    }

    public List<Tareas> buscarDescripcion(String target) {
        List<Tareas> tareas = (List<Tareas>) em.createQuery("FROM tareas WHERE (descripcion LIKE '%"+target+"%')").getResultList();
        return tareas;
    }

    public void close() {
        this.emf.close();
        this.em.close();
    }
}