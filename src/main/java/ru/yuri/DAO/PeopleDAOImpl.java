package ru.yuri.DAO;

import org.springframework.stereotype.Repository;
import ru.yuri.model.People;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<People> index() {
        return manager.createQuery("select p from People p").getResultList();
    }

    @Override
    public People get(int id) {
        return manager.find(People.class, new Long(id));
    }

    @Override
    public void save(People people) {
        manager.persist(people);
    }

    @Override
    public void update(People people) {
        manager.merge(people);
    }

    @Override
    public void delete(int id) {
        manager.remove(get(id));
    }

    @Override
    public People getUserByName(String username) {
        return null;
//                (People) manager.createQuery("select p from People as p where p.name = :nam")
//                .setParameter("nam", username)
//                .getSingleResult();
    }


}
