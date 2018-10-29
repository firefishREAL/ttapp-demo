package com.zr.ttappdemo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuyi
 * @since 2018-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("opinion")
public class Opinion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评价/投诉表主键
     */
    @TableId(value = "opinion_id", type = IdType.AUTO)
    private Integer opinionId;

    /**
     * 评价/投诉人ID
     */
    private Integer userId;

    /**
     * 对应商品或订单ID
     */
    private Integer objectId;

    /**
     * 被评价/投诉人ID
     */
    private Integer accusedId;

    /**
     * 评价投诉内容
     */
    private String content;

    /**
     * 类型：评价，投诉
     */
    private Integer opinionType;

    /**
     * 意见状态
     */
    private Integer opinionStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean deleted;


}
