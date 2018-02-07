package cn.winner.cloud.service.impl;

import cn.winner.cloud.service.UserService;
import cn.winner.cloud.service.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User queryUserInfo() {
        User user = new User();
        user.setAddress("杭州");
        user.setName("小领子");
        user.setPwd("123");
        return user;
    }
}
