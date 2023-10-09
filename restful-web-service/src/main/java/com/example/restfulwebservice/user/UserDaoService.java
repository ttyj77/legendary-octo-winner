package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount =3;
    static {
        users.add(new User(1, "juHee", new Date()));
        users.add(new User(2, "jungHoo", new Date()));
        users.add(new User(3, "Kong", new Date()));
    }
    /*전체사용자 목록 조회*/
    public List<User> findAll() {
        return users;
    }

    /*사용자 추가*/
    public User save(User user){
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    /*개별 사용자 조회*/
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
