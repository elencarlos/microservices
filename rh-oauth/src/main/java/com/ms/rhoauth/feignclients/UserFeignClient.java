package com.ms.rhoauth.feignclients;

import com.ms.rhoauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {
    @GetMapping("/search")
    ResponseEntity<User> findByEmail(@RequestParam() String email);
}
