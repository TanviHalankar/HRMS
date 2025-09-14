package com.hrms.employee_service.service;


import com.hrms.employee_service.entity.User;
import com.hrms.employee_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        return userRepository.save(user); // save will update if ID exists
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
