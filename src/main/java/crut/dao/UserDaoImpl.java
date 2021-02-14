package crut.dao;

import crut.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);

    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeUser(long id) {
        if (getUserById(id)!=null)
            em.remove(getUserById(id));
    }

    @Override
    public User getUserById(long id) {

        return em.find(User.class, id);

    }

    @Override
    public List<User> getAllUser() {
      List<User> users =  em.createQuery("from User").getResultList();

        return  users;

    }
}
