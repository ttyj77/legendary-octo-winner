package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-world") // endPoint
    public String helloWorld(){
        return "Hello World";
    }
    //alt + enter`
    @GetMapping("/hello-world-bean") // endPoint
    public HelloWordBean helloWorldBean(){
        return new HelloWordBean("Hello World");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWordBean helloWordBean(@PathVariable String name){
        return new HelloWordBean(String.format("두두둥, %s",name)); // + 으로 연결해도 되지만,
    }

}
