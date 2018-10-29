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
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 对应商品ID
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 对应的项目分类主键字符串，eg:1,2,3,4,5
     */
    private String categories;

    /**
     * 商品类型
     */
    private Integer productType;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品活动规则
     */
    private String rules;

    /**
     * 开始时间
     */
    private LocalDateTime startedAt;

    /**
     * 结束时间
     */
    private LocalDateTime endAt;

    /**
     * 发布地点或区域
     */
    private String area;

    /**
     * 备注
     */
    private String remark;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 总人数
     */
    private Integer total;

    /**
     * 商品发布坐标经度
     */
    private String longitude;

    /**
     * 商品发布坐标纬度
     */
    private String latitude;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Boolean deleted;


}
