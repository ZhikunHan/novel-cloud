package com.hantiv.novel.user.entity;

import com.hantiv.novel.common.valid.AddGroup;
import com.hantiv.novel.common.valid.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    @Null(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotBlank(groups = {AddGroup.class},message="手机号不能为空！")
    @Pattern(groups = {AddGroup.class},regexp="^1[3|4|5|6|7|8|9][0-9]{9}$",message="手机号格式不正确！")
    @ApiModelProperty(value = "登录名")
    private String username;

    @NotBlank(groups = {AddGroup.class},message="密码不能为空！")
    @Null(groups = {UpdateGroup.class})
    @ApiModelProperty(value = "登录密码")
    private String password;

    @Null(groups = {AddGroup.class})
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @Null(groups = {AddGroup.class})
    @ApiModelProperty(value = "用户头像")
    private String userPhoto;

    @Null(groups = {AddGroup.class})
    @Min(value = 0,groups = {UpdateGroup.class})
    @Max(value = 1,groups = {UpdateGroup.class})
    @ApiModelProperty(value = "用户性别，0：男，1：女")
    private Byte userSex;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "账户余额")
    private Long accountBalance;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "用户状态，0：正常")
    private Byte status;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}