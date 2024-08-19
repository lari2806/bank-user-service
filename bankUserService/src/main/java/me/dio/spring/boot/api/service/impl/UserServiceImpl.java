package me.dio.spring.boot.api.service.impl;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import me.dio.spring.boot.api.domain.model.User;
import me.dio.spring.boot.api.domain.repository.UserRepository;
import me.dio.spring.boot.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists");
        }
        
            return userRepository.save(user);
        
    }
    
}
