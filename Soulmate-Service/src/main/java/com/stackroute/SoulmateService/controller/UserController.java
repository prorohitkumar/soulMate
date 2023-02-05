package com.stackroute.SoulmateService.controller;

import com.stackroute.SoulmateService.model.Profile;
import com.stackroute.SoulmateService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Rohit
 * @Date 29-Oct-21 4:31 PM
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<Profile> saveUser(@RequestBody Profile profile)
    {
        Profile savedProfile = userService.saveUser(profile);
        //TODO call ProfileMessageProducer to publish savedProfile into rabbitmq
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<Profile>> getAllUsers()
    {
        return new ResponseEntity<List<Profile>>((List<Profile>) userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("user/{email}")
    public ResponseEntity<Profile> deleteUser(@PathVariable("email") String email)
    {
        return new ResponseEntity<>(userService.deleteUser(email),HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<Profile> updateUser(@RequestBody Profile profile)
    {
        Profile updatedProfile = userService.updateUser(profile);
        return new ResponseEntity<>(updatedProfile,HttpStatus.OK);
    }
    @GetMapping("users/{email}")
    public ResponseEntity<Profile> getUserByEmail(@PathVariable("email") String email)
    {
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }


}
