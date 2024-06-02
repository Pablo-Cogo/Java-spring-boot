package com.example.demo.service;

import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        try {
            Optional<User> obj = userRepository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    public User update(Long id, User userData) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
            user.setNome(userData.getNome());
            user.setEmail(userData.getEmail());
            user.setTelefone(userData.getTelefone());
            user.setPassword(userData.getPassword());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }
}
