package com.zr.ttappdemo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("counter")
public class Counter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 计数统计ID
     */
    @TableId(value = "counter_id", type = IdType.AUTO)
    private Integer counterId;

    /**
     * 关联terms表，记录terms表被使用的次数
     */
    private Integer objectId;

    /**
     * 计数总和
     */
    private Integer count;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;


}
