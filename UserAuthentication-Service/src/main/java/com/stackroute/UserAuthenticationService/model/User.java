package com.stackroute.UserAuthenticationService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * @Author Rohit
 * @Date 30-Oct-21 8:59 AM
 */

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class User {
    @Id
    private String email;
    private String password;

}
