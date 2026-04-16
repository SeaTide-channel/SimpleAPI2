package com.seatide.springbootdemo.controller;

import cn.hutool.core.io.IoUtil;
import com.seatide.springbootdemo.pojo.User;
import com.seatide.springbootdemo.service.UserService;
import com.seatide.springbootdemo.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController


public class UserController {

    private UserService userService;


    @RequestMapping("/list")
    public List<User> list() throws Exception {
        //1.调用service
        List<User> userList = userService.findAll();



        return userList;
    }
}
