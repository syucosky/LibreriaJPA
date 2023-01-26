package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {
    
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = EMF.createEntityManager();
    
    protected void conectar(){
        if(!em.isOpen()){
            em = EMF.createEntityManager();
        }
    }
    protected void desconectar(){
        if(em.isOpen()){
            em.close();
        }
    }
    
    protected void guardar(T obj){     
        conectar();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T obj){
        conectar();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        desconectar();               
    }
    
    
    
}
