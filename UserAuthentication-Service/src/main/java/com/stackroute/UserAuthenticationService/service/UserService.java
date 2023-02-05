package com.stackroute.UserAuthenticationService.service;

import com.stackroute.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthenticationService.exception.UserNotFoundException;
import com.stackroute.UserAuthenticationService.model.User;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:03 AM
 */
public interface UserService {
    User saveUser (User user) throws UserAlreadyExistsException;
    User findUserByEmailId (String email) throws UserNotFoundException;
    boolean validateUser (User user) throws UserNotFoundException;


}
