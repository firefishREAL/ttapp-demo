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
@TableName("state")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户动态表ID
     */
    @TableId(value = "state_id", type = IdType.AUTO)
    private Integer stateId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 动态内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 动态所在地点
     */
    private String area;

    /**
     * 动态发布状态权限
     */
    private Integer stateStatus;

    /**
     * 动态发布所在坐标经度
     */
    private String longitude;

    /**
     * 动态发布所在坐标纬度
     */
    private String latitude;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean deleted;


}
