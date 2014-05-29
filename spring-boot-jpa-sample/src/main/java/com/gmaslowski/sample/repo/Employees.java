package com.gmaslowski.sample.repo;

import com.gmaslowski.sample.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class Employees extends AbstractBaseEntityJpaRepository<Employee> {

    @Override
    @PersistenceContext
    protected void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<Employee> listAll() {
        return em.createQuery("from Employee e").getResultList();
    }

}
