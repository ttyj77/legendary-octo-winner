package com.example.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    /*스프링 프레임워크에 인해서 인스턴스가 관리되도록 선언해서 사용 new(X)*/
    private UserDaoService service;

    /*생성지를 통한 의존성 주입*/
    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        /* 201 created post 메소드의 생성 결과값으로 생성된 아이디를 전달받을 수 있다. ex)http://localhost:8090/users/123 */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return  ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}") // {id} -> string 이지만 밑에 int로 선언하면 자동으로 타입 변환 가능
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }
}
