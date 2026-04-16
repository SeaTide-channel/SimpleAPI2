package com.seatide.springbootdemo.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.seatide.springbootdemo.dao.UserDao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
@Override
    public List<String> findAll(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, "utf-8", new ArrayList<>());
        return lines;
    }

}
