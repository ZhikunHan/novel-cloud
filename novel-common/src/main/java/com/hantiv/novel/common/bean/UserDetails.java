package com.hantiv.novel.common.bean;

import lombok.Data;

/**
 * 登陆用户信息封装
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@Data
public class UserDetails {

    private Long id;

    private String username;

    private String nickName;
}
