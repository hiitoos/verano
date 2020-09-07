package com.main.application.repositories;

import com.main.application.domain.entities.Estado;
import com.main.application.domain.entities.Login;
import com.main.application.domain.entities.Tarea;
import com.main.application.domain.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.InputMismatchException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

@Repository
public class Hibernate {
    private static SessionFactory Factory;

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static CriteriaBuilder cb;
    private static Session session;

    public Hibernate() {
        //this.emf = Persistence.createEntityManagerFactory("VeranoPersistence");
        //this.em = this.emf.createEntityManager();
        cb = em.getCriteriaBuilder();

        try {
            Configuration config = new Configuration();
            config.addAnnotatedClass(Estado.class);
            config.addAnnotatedClass(Login.class);
            config.addAnnotatedClass(Tarea.class);
            config.addAnnotatedClass(Usuario.class);
            config.configure();
            Factory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void createUpdateTarea(Tarea newT) {
        session = Factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(newT);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        System.out.println("¡¡Hecho!!");
    }

    public static void showT() {
        session = Factory.openSession();
        CriteriaQuery<Tarea> q = cb.createQuery(Tarea.class);
        q.select(q.from(Tarea.class));
        List<Tarea> tarList = session.createQuery(q).getResultList();
        for(Tarea trl : tarList){
            System.out.println(trl.toString());
        }
        session.close();
    }

    public static List<Tarea> getTarea(){
        session = Factory.openSession();
        CriteriaQuery<Tarea> q = cb.createQuery(Tarea.class);
        q.select(q.from(Tarea.class));
        List<Tarea> tarList = session.createQuery(q).getResultList();
        session.close();
        return tarList;
    }

    public static void showUser() {
        session = Factory.openSession();
        CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
        q.select(q.from(Usuario.class));
        List<Usuario> usuList = session.createQuery(q).getResultList();
        for(Usuario usl : usuList){
            System.out.println(usl.toString());
        }
        session.close();
    }

    public static void deleteTarea(int id) {
        session = Factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Tarea idDelete = session.load(Tarea.class, id);
            session.delete(idDelete);
            transaction.commit();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        System.out.println("¡¡Tarea borrada!!");
    }

    public static void readEstado() {
        session = Factory.openSession();
        CriteriaQuery<Estado> q = cb.createQuery(Estado.class);
        q.select(q.from(Estado.class));
        List<Estado> esList = session.createQuery(q).getResultList();
        for(Estado esl : esList){
            System.out.println(esl.toString());
        }
        session.close();
    }

    public static void buscarUsuario(String usuario) {
        try{
        CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
        Root<Usuario> c = q.from(Usuario.class);
            q.where(cb.like(c.get("nombre"), "%"+usuario+"%"));
            List<Usuario> usuarioList = em.createQuery(q).getResultList();
            for(Usuario usl : usuarioList){
                for (Tarea tarea : usl.getTareas()){
                    System.out.println(tarea.toString());
                }
            }
        }catch (InputMismatchException ex){
            System.out.println(ex);
        }
    }

    public static List<Usuario> idUsuario(){
        session = Factory.openSession();
        CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
        q.select(q.from(Usuario.class));
        //Lo importante
        List<Usuario> usuList = session.createQuery(q).getResultList();
        session.close();
        return usuList;
    }

    public static void close() {
        emf.close();
        em.close();
        Factory.close();
    }
}