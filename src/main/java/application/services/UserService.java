package application.services;

import application.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);


    List<User> findAll();


    void deleteById(long id);


    User findById(long id);


    void updateUser(User user);
}
