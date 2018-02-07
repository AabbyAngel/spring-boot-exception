package cn.winner.cloud.controller;

import cn.winner.cloud.exception.BizException;
import cn.winner.cloud.exception.builder.ErrorBuilder;
import cn.winner.cloud.service.UserService;
import cn.winner.cloud.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/info")
    public User queryInfo(String name) {
        //自定义错误
        if (name.equals("hundsun")) {
            throw new BizException(ErrorBuilder.buildBindError("用户名错误"));
        }
        //运行时错误
        if (name.equals("iwin")) {
            int i = 1 / 0;
            return new User();
        }
        // 正确的数据
        return userService.queryUserInfo();
    }
}
