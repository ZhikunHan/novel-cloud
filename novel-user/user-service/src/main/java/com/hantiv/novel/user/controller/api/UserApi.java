package com.hantiv.novel.user.controller.api;


import com.hantiv.novel.user.service.UserService;
import com.hantiv.novel.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 用户微服务API接口（内部调用）
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@ApiIgnore
public class UserApi {

    private final UserService userService;

    /**
     * 根据用户名密码查询记录
     * */
    @GetMapping("queryByUsernameAndPassword")
    public User queryByUsernameAndPassword(String username, String password){
        return userService.queryByUsernameAndPassword(username,password);

    }

    /**
     * 根据用户名ID集合查询用户集合信息
     * @param ids 用户ID集合
     * @return 用户集合对象
     * */
    @GetMapping("queryById")
    List<User> queryById(@RequestBody List<Long> ids){
        return userService.queryById(ids);
    }



}
