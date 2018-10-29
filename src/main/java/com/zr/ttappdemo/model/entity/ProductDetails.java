package com.zr.ttappdemo.model.entity;

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
@TableName("product_details")
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 商品主键
     */
    private Integer productId;

    /**
     * 消费详情描述
     */
    private String description;

    /**
     * 实际支付金额
     */
    private BigDecimal realPayment;

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
