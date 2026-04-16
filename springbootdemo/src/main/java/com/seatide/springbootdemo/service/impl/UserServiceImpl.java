package com.seatide.springbootdemo.service.impl;


import com.seatide.springbootdemo.dao.UserDao;
import com.seatide.springbootdemo.dao.impl.UserDaoImpl;
import com.seatide.springbootdemo.pojo.User;
import com.seatide.springbootdemo.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao，获取数据
        List<String> lines= userDao.findAll();

        List<User> userList = lines.stream().map(line -> {
            // 将line数据通过"，"进行分割
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());


        return userList;
    }
}
