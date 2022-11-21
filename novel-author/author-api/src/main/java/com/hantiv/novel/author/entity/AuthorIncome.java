package com.hantiv.novel.author.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Zhikun Han
 * @Date Created in 20:52 2022/11/12
 * @Description:
 */
@TableName("author_income")
@Data
public class AuthorIncome implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 作家ID
     */
    private Long authorId;

    /**
     * 小说ID
     */
    private Long bookId;

    /**
     * 收入月份
     */
    private Date incomeMonth;

    /**
     * 税前收入;单位：分
     */
    private Integer preTaxIncome;

    /**
     * 税后收入;单位：分
     */
    private Integer afterTaxIncome;

    /**
     * 支付状态;0-待支付 1-已支付
     */
    private Integer payStatus;

    /**
     * 稿费确认状态;0-待确认 1-已确认
     */
    private Integer confirmStatus;

    /**
     * 详情
     */
    private String detail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
