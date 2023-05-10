package com.MyBodyDateAppBack.controller;

import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MyBodyDateAppBack.entity.User;
import com.MyBodyDateAppBack.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        String result = userService.saveUser(user);
        if (result.contains("already exists")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            return ResponseEntity.created(URI.create("/api/users/" + user.getId())).body(user);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) throws InterruptedException, ExecutionException {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() throws InterruptedException, ExecutionException {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<User>> getUsersByCity(@PathVariable String city) throws InterruptedException, ExecutionException {
        List<User> users = userService.getUsersByCity(city);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) throws InterruptedException, ExecutionException {
        user.setId(id);
        String result = userService.updateUser(user);
        if (result.contains("does not exist")) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        String result = userService.deleteUser(id);
        if (result.contains("does not exist")) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
