package com.stackroute.SoulmateService.repository;

import com.stackroute.SoulmateService.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 29-Oct-21 4:30 PM
 */
@Repository
public interface UserRepository extends MongoRepository<Profile,String> {
}
