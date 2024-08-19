package me.dio.spring.boot.api.service;

import me.dio.spring.boot.api.domain.model.User;

public interface UserService {

    User findById(long id);
    
    User create(User user);
}
