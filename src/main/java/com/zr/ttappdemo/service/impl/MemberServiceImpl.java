package com.zr.ttappdemo.service.impl;

import com.zr.ttappdemo.model.entity.Member;
import com.zr.ttappdemo.dao.MemberMapper;
import com.zr.ttappdemo.service.MemberService;
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
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
