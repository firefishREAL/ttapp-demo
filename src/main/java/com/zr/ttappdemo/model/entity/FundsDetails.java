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
@TableName("funds_details")
public class FundsDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资金明细表主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 交易类型
     */
    private Integer tradeType;

    /**
     * 交易流水号
     */
    private String serialNo;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 支付渠道流水号
     */
    private String outTradeNo;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 交易币种
     */
    private Integer currency;

    /**
     * 交易状态
     */
    private Integer status;

    /**
     * 交易参数
     */
    private String tradeParams;

    /**
     * 手续费
     */
    private BigDecimal commission;

    /**
     * 交易备注
     */
    private String tradeRemark;

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
