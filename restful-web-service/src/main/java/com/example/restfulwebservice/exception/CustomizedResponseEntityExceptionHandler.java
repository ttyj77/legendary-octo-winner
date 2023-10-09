package com.example.restfulwebservice.exception;

import com.example.restfulwebservice.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//RestApI에서 발생하는 모든 예외객체에 대해서 예외 메세지나 코드를 커스터 마이징 하면 RestAPI의 완성도를 높일 수 있다.
@RestController
@ControllerAdvice //모든 컨트롤러가 실행될 때 반드시 @ControllerAdvice 어노테이션을 가지고 있는 빈이 사전에 실행 됨
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    /*전달하고자 하는 내용만 에러로 표시할 수 있다. 모든 에러메세지를 노출하면 보안상의 문제가 있다.*/
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR); //500 //<>제거 : 오브젝트 형태이기 떄문에 제네릭 타입은 필요없다.
    }

    @ExceptionHandler(UserNotFoundException.class) //잡아야 하는 오류 지정
    public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND); //404
    }


}
