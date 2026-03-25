package com.example.userService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userService.model.User;
import com.example.userService.repository.UserRepository;

import com.example.userService.exception.UserNotFoundExistException;

@Service
public class UserService 
{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }


    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public User getUserById(String id)

    {
         User existingUser =userRepository.findById(id)
        .orElseThrow(()-> new UserNotFoundExistException("user Not Exist "));
        
      
        return existingUser;
        

    }

    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    public User updateUser(User user,String id)
    {
        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundExistException("user Not Exist"));

        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setAddress(user.getAddress());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    public  void removeUser(String id) 
    {
       userRepository.findById(id)
        .orElseThrow(()-> new UserNotFoundExistException("user Not Exist "));
        
       
        
        userRepository.deleteById(id);
        

        
    }
}
