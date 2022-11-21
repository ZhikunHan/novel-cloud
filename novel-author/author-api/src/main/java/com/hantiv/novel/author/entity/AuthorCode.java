package com.hantiv.novel.author.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@TableName("author_code")
@Data
public class AuthorCode {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 有效时间
     */
    private Date validityTime;

    /**
     * 是否使用过;0-未使用 1-使用过
     */
    private Integer isUsed;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}