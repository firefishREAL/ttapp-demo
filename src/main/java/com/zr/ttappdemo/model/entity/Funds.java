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
@TableName("funds")
public class Funds implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资金表主键
     */
    @TableId(value = "funds_id", type = IdType.AUTO)
    private Integer fundsId;

    /**
     * 用户总资金
     */
    private BigDecimal totalFunds;

    /**
     * 用户储蓄资金
     */
    private BigDecimal savingFunds;

    /**
     * 用户vip资金
     */
    private BigDecimal vipFunds;

    /**
     * 用户礼物资金
     */
    private BigDecimal giftFunds;

    /**
     * 冻结资金
     */
    private BigDecimal freezeFunds;

    /**
     * 提成资金
     */
    private BigDecimal commissionFunds;

    /**
     * 会员充值累计
     */
    private BigDecimal vipGrandTotal;

    /**
     * 用户对应主键
     */
    private Integer userId;

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
