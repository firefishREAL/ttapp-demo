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
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单主键ID
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 商品名称
     */
    private String productTitle;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 买家姓名
     */
    private String userName;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付时间
     */
    private LocalDateTime paymentAt;

    /**
     * 支付状态
     */
    private Integer paymentStatus;

    /**
     * 支付价格
     */
    private BigDecimal paymentPrice;

    /**
     * 支付类型
     */
    private Integer paymentType;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 优惠金额
     */
    private BigDecimal offerAmount;

    /**
     * 最终交易价格
     */
    private BigDecimal realPayment;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 卖家ID
     */
    private Integer sellerId;

    /**
     * 卖家姓名
     */
    private String sellerName;

    /**
     * 订单开始时间
     */
    private LocalDateTime startedAt;

    /**
     * 订单结束时间
     */
    private LocalDateTime endAt;

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
