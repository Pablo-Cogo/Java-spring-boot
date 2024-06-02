package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User insert(@RequestBody User obj) {
        return userService.insert(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User obj) {
        return userService.update(id, obj);
    }

}
