package com.zr.ttappdemo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("terms")
public class Terms implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目主键：项目分类，标签，礼物
     */
    @TableId(value = "term_id", type = IdType.AUTO)
    private Integer termId;

    /**
     * 项目分类名称或标签名称
     */
    private String termName;

    /**
     * 分类：项目或标签或礼物
     */
    private Integer termCategory;

    /**
     * 项目分类类型：当term_type 为项目分类或礼物时该字段可填
     */
    private Integer termType;

    /**
     * 单价，仅当分类为礼物时可用
     */
    private BigDecimal price;

    /**
     * 父标签ID
     */
    private Integer parentId;

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

    /**
     * term状态
     */
    private Integer termStatus;


}
