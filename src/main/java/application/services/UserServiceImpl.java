package application.services;

import application.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext()
    private EntityManager entityManager;


    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }


    @Transactional
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }


    @Transactional
    @Override
    public void deleteById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }


    @Transactional
    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }


    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}

