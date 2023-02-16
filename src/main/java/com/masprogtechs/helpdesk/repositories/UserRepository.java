package com.masprogtechs.helpdesk.repositories;

import com.masprogtechs.helpdesk.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
