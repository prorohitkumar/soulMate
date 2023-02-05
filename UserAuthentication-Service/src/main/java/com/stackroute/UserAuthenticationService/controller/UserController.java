package com.stackroute.UserAuthenticationService.controller;

import com.stackroute.UserAuthenticationService.exception.UserNotFoundException;
import com.stackroute.UserAuthenticationService.model.User;
import com.stackroute.UserAuthenticationService.service.TokenGenerator;
import com.stackroute.UserAuthenticationService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:08 AM
 */
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/loginuser")
    public ResponseEntity<?> authenticateUser (@RequestBody User user) {
        log.debug("Login request received for user" + user + "at " + java.time.LocalDateTime.now());
        ResponseEntity responseEntity = null;
        try {
            boolean result = userService.validateUser(user);
            if (result) {
                String jwtToken = TokenGenerator.generateToken(user);
                responseEntity = new ResponseEntity(jwtToken, HttpStatus.OK);
            }
        } catch (UserNotFoundException e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }
}
