package com.ms.hruser.resources;

import com.ms.hruser.entities.User;
import com.ms.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam() String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user.get());
    }
}
