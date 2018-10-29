package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.Counter;
import com.zr.ttappdemo.dao.CounterMapper;
import com.zr.ttappdemo.service.CounterService;
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
public class CounterServiceImpl extends ServiceImpl<CounterMapper, Counter> implements CounterService {

}
