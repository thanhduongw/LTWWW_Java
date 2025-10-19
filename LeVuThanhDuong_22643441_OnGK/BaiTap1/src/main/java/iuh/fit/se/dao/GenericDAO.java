package iuh.fit.se.dao;

import iuh.fit.se.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class GenericDAO<T> {
    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public void save(T entity){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            em.getTransaction();

            em.persist(entity);

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public void delete(long id){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            em.getTransaction();

            T entity = em.find(type, id);
            if(entity!= null)
                em.remove(entity);

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public T findById(long id){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            return em.find(type, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return null;
    }

}
