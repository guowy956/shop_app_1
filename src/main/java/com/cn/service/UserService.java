package com.cn.service;

import com.cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 用户操作
 *
 * @author guowy
 * @create 2017-06-08 16:45
 **/
@Service
public class UserService <T,Q,PK extends Serializable> extends CommonsService<T,Q,PK> {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserMapper getMapper() {
        return userMapper;
    }
}
