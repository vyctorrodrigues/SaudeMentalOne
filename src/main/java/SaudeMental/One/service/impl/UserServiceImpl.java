package SaudeMental.One.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SaudeMental.One.model.User;
import SaudeMental.One.model.repository.UserRepository;
import SaudeMental.One.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
       return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
       user.setId(id);
       return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
   
}

