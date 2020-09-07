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

    public Hibernate() {
        this.emf = Persistence.createEntityManagerFactory("VeranoPersistence");
        this.em = this.emf.createEntityManager();
    }

    public static void createTarea(Tarea newT) {
        em.getTransaction().begin();
        em.persist(newT);
        em.getTransaction().commit();
    }

    public static void showT() {
        List<Tarea> tareas = (List<Tarea>) em.createQuery("FROM Tarea").getResultList();
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

    public static List<Tarea> getTearea(){
        List<Tarea> tareas = (List<Tarea>) em.createQuery("FROM Tarea").getResultList();
        return tareas;
    }

    public static void showUser() {
        List<Usuario> users = (List<Usuario>) em.createQuery("FROM Usuario").getResultList();
        for(int i=0; i<users.size(); i++){
            System.out.println("ID: " + users.get(i).getId());
            System.out.println("Nombre: " + users.get(i).getNombre());
            System.out.println("Apellidos: " + users.get(i).getApellidos());
            System.out.println("Email: " + users.get(i).getEmail());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public static void updateTarea(Tarea tarea) {
        //em.getTransaction().begin();
        em.merge(tarea);
        //em.getTransaction().commit();
        System.out.println("¡¡Tarea actualizada!!");
    }

    public static void deleteTarea(int id) {
        Tarea tarea =  em.find(Tarea.class, id);
        //em.getTransaction().begin();
        em.remove(tarea);
        //em.getTransaction().commit();
        System.out.println("¡¡Tarea eliminada!!");
    }

    public static void readEstado() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Estado> q = cb.createQuery(Estado.class);
        Root<Estado> c = q.from(Estado.class);
        //Lo importante
        List<Estado> estadoList = em.createQuery(q).getResultList();
        for(Estado esl : estadoList){
            System.out.println(esl.toString());
        }
    }

    public static void buscarUsuario(String usuario) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
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
        CriteriaBuilder cb = em.getCriteriaBuilder();
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