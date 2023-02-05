package com.stackroute.SoulmateService.service;

import com.stackroute.SoulmateService.model.Profile;
import com.stackroute.SoulmateService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author Rohit
 * @Date 29-Oct-21 4:30 PM
 */
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Profile saveUser(Profile profile) {
        return userRepository.save(profile);
    }

    @Override
    public List<Profile> getAllUsers() {
        return (List<Profile>) userRepository.findAll();
    }

    @Override
    public Profile deleteUser(String email) {
        Profile profile = null;
        Optional optional = userRepository.findById(email);
        if (optional.isPresent())
        {
            profile = userRepository.findById(email).get();
            userRepository.deleteById(email);
        }
        return profile;
    }

    @Override
    public Profile updateUser(Profile profile) {
        Profile updatedProfile = null;
        Optional optional = userRepository.findById(profile.getEmail());
        if (optional.isPresent()){
            Profile getProfile = userRepository.findById(profile.getEmail()).get();
            getProfile.setEmail(profile.getEmail());
            updatedProfile = saveUser(getProfile);
        }
        return updatedProfile;
    }

    @Override
    public Profile getUserByEmail(String email) {
        Profile profile = null;
        profile = userRepository.findById(email).get();
        return profile;
    }
}
