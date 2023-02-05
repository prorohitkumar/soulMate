package com.stackroute.UserAuthenticationService.exception;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:04 AM
 */
public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
