package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.State;
import com.zr.ttappdemo.dao.StateMapper;
import com.zr.ttappdemo.service.StateService;
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
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService {

}
