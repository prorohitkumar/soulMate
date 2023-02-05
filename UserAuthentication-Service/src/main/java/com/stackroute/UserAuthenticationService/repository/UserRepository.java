package com.stackroute.UserAuthenticationService.repository;

import com.stackroute.UserAuthenticationService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:02 AM
 */
public interface UserRepository extends JpaRepository<User,String> {
}
