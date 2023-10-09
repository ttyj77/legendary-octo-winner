package com.example.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Http Status code
//2XX -> OK
//4XX -> Client
//5XX -> Server
@ResponseStatus(HttpStatus.NOT_FOUND) //4XX 으로 상태코드 지정
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message); //생성자는 부모쪽으로 넘김

    }
}
