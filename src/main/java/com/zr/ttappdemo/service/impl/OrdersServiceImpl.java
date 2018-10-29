package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.Orders;
import com.zr.ttappdemo.dao.OrdersMapper;
import com.zr.ttappdemo.service.OrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
