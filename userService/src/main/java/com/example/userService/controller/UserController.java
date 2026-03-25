package com.example.userService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.model.User;
import com.example.userService.service.UserService;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("{id}")
   public ResponseEntity<User> getById(@PathVariable String id )
   {
    return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
   }

    @GetMapping
    public ResponseEntity<List<User>> getAll()
    {
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String id)
    {
        
        return new ResponseEntity<>(userService.updateUser(user, id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeUser(@PathVariable String id)
    {
        userService.removeUser(id);

        return  ResponseEntity.noContent().build();

    }


}
