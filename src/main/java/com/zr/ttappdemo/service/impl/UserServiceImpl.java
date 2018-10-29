package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.User;
import com.zr.ttappdemo.dao.UserMapper;
import com.zr.ttappdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuyi
 * @since 2018-10-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
