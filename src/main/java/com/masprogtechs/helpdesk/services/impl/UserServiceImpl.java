package com.masprogtechs.helpdesk.services.impl;

import com.masprogtechs.helpdesk.entities.User;
import com.masprogtechs.helpdesk.repositories.UserRepository;
import com.masprogtechs.helpdesk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User createOrUpdate(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userRepository.findById(id);

    }

    @Override
    public void delete(String id) {
       this.userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(int page, int count) {
        return this.userRepository.findAll(PageRequest.of(page, count));
    }
}
