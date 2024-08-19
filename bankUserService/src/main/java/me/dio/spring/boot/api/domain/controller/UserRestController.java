package me.dio.spring.boot.api.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.spring.boot.api.domain.model.User;
import me.dio.spring.boot.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
    
    private final UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        var userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
