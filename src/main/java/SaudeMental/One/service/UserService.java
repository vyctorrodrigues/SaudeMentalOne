package SaudeMental.One.service;

import java.util.List;

import SaudeMental.One.model.User;

public interface  UserService {
    
    User createUser(User user);

    User findById(Long id);

    List<User> findAllUsers();

    User updateUser(Long id, User user);
    
    void deleteUser(Long id);

}
