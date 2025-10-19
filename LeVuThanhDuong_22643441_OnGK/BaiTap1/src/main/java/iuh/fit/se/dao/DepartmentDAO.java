package iuh.fit.se.dao;

import iuh.fit.se.model.Department;
import iuh.fit.se.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartmentDAO extends GenericDAO<Department> {
    public DepartmentDAO() {
        super(Department.class);
    }

    public List<Department> findAll(){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            String jpql = """
                    SELECT d FROM Department d
                    """;
            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            return query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return null;
    }
}
