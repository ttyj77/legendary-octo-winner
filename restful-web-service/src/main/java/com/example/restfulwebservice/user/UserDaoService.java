package com.example.restfulwebservice.user;

import org.hibernate.Internal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

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
    public User save(User user) {
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

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator(); //열거형 타입으로 변경
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateById(int id, User userInfo) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                user.setName(userInfo.getName());
                user.setJoinDate(user.getJoinDate());
                return user;
            }
        }
        return null;
    }
}
