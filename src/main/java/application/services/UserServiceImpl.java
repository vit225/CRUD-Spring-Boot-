package application.services;

import application.dao.UserDao;
import application.models.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(long id) {
       userDao.deleteById(id);
        }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}

