package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.ProductDetails;
import com.zr.ttappdemo.dao.ProductDetailsMapper;
import com.zr.ttappdemo.service.ProductDetailsService;
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
public class ProductDetailsServiceImpl extends ServiceImpl<ProductDetailsMapper, ProductDetails> implements ProductDetailsService {

}
