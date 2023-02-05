package com.stackroute.UserAuthenticationService.exception;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:04 AM
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
