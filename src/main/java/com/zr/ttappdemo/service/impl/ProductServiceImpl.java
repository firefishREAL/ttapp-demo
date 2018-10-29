package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.Product;
import com.zr.ttappdemo.dao.ProductMapper;
import com.zr.ttappdemo.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
