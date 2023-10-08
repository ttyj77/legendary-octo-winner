package com.example.restfulwebservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor //모든 argument를 가진 생성자 생성
@NoArgsConstructor // 아무것도 없는 default 생성자 생성
public class HelloWordBean {
    private String message;

}
