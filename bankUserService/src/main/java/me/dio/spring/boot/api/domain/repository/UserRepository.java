package me.dio.spring.boot.api.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.dio.spring.boot.api.domain.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
    
}