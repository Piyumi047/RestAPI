package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/postUser")
    public UserDTO postUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/putUser")
    public UserDTO putUser(@RequestBody UserDTO userDTO){

        return  userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){

        return userService.deleteUser(userDTO) ;
    }


    @GetMapping("/getUserById/{userID}")
    public UserDTO getUserByUserId(@PathVariable String userId){
        return userService.getUserById(userId);
    }
    @GetMapping("/getUserByIdAndAddress/{userID}/{address}")
    public UserDTO getUserByUserIdAndAddress(@PathVariable String userId,@PathVariable String address){
        return userService.getUserByIdAndAddress(userId,address);
    }

}
