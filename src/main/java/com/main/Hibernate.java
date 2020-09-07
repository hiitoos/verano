package com.main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Hibernate {
    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static CriteriaBuilder cb;

    public Hibernate() {
        this.emf = Persistence.createEntityManagerFactory("VeranoPersistence");
        this.em = this.emf.createEntityManager();
        cb = em.getCriteriaBuilder();
    }

    public static void createTarea(Tarea newT) {
        em.getTransaction().begin();
        em.persist(newT);
        em.getTransaction().commit();
    }

    public static void showT() {
        CriteriaQuery<Tarea> q = cb.createQuery(Tarea.class);
        Root<Tarea> c = q.from(Tarea.class);
        //Lo importante
        List<Tarea> tarList = em.createQuery(q).getResultList();
        for(Tarea trl : tarList){
            System.out.println(trl.toString());
        }
    }

    public static List<Tarea> getTearea(){
        List<Tarea> tareas = (List<Tarea>) em.createQuery("FROM Tarea").getResultList();
        return tareas;
    }

    public static void showUser() {
        CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
        Root<Usuario> c = q.from(Usuario.class);
        //Lo importante
        List<Usuario> usuList = em.createQuery(q).getResultList();
        for(Usuario usl : usuList){
            System.out.println(usl.toString());
        }
    }

    public static void updateTarea(Tarea tarea) {
        em.merge(tarea);
        System.out.println("¡¡Tarea actualizada!!");
    }

    public static void deleteTarea(int id) {
        Tarea tarea =  em.find(Tarea.class, id);
        em.remove(tarea);
        System.out.println("¡¡Tarea eliminada!!");
    }

    public static void readEstado() {
        CriteriaQuery<Estado> q = cb.createQuery(Estado.class);
        Root<Estado> c = q.from(Estado.class);
        //Lo importante
        List<Estado> estadoList = em.createQuery(q).getResultList();
        for(Estado esl : estadoList){
            System.out.println(esl.toString());
        }
    }

    public static void buscarUsuario(String usuario) {
        CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
        Root<Usuario> c = q.from(Usuario.class);
        //Lo importante
        q.where(cb.like(c.get("nombre"), usuario));
        List<Usuario> usuarioList = em.createQuery(q).getResultList();

        for(Usuario usl : usuarioList){
            for (Tarea tarea : usl.getTareas()){
                System.out.println(tarea.toString());
            }
        }
    }

    public static List<Usuario> idUsuario(){
        CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
        Root<Usuario> c = q.from(Usuario.class);
        //Lo importante
        List<Usuario> usuList = em.createQuery(q).getResultList();
        return usuList;
    }

    public static void close() {
        emf.close();
        em.close();
    }
}