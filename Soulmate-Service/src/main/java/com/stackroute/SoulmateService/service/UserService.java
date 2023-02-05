package com.stackroute.SoulmateService.service;

import com.stackroute.SoulmateService.model.Profile;

import java.util.List;

/**
 * @Author Rohit
 * @Date 29-Oct-21 4:31 PM
 */
public interface UserService {
    Profile saveUser(Profile profile);
    List<Profile> getAllUsers();
    Profile deleteUser(String email);
    Profile updateUser(Profile profile);
    Profile getUserByEmail(String email);
}
