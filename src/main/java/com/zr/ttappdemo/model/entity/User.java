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
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户性别
     */
    private Integer gender;

    /**
     * 用户生日
     */
    private LocalDateTime birthday;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 用户头像所在地址
     */
    private String icon;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 用户状态
     */
    private Integer userStatus;

    /**
     * 用户所在位置经度
     */
    private String longitude;

    /**
     * 用户所在位置纬度
     */
    private String latitude;

    /**
     * 用户所属省份ID
     */
    private Integer provinceId;

    /**
     * 用户所属城市ID
     */
    private Integer cityId;

    /**
     * 推荐人ID
     */
    private Integer referee;

    /**
     * 用户所拥有的标签，eg:1,2,3,4
     */
    private String labels;

    /**
     * 用户评分
     */
    private Integer userScore;

    /**
     * 用户星级
     */
    private Integer level;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户身高
     */
    private String height;

    /**
     * 用户体重
     */
    private String weight;

    /**
     * 对应会员ID
     */
    private Integer memberId;

    /**
     * 会员更新时的时间记录
     */
    private LocalDateTime memberUpdatedAt;

    /**
     * 用户token
     */
    private String userToken;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean deleted;

    /**
     * 用户更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 用户创建时间
     */
    private LocalDateTime createdAt;


}
