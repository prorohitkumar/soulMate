package com.stackroute.UserAuthenticationService.bootstrap;

import com.stackroute.UserAuthenticationService.model.User;
import com.stackroute.UserAuthenticationService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:14 AM
 */
@Slf4j
public class BootstrapUserData implements CommandLineRunner {

    private UserRepository userRepository;

    public BootstrapUserData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Inside run method");
        User user1 = new User("sivasankaran@abc.com", "sanjay");
        User user2 = new User("rohit@abc.com", "rohit");
        userRepository.save(user1);
        userRepository.save(user2);
        log.debug("Saved 2 users");
    }
}
