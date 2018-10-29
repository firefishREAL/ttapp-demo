package com.zr.ttappdemo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zr.ttappdemo.commons.util.PageVo;
import com.zr.ttappdemo.commons.util.ResultVo;
import com.zr.ttappdemo.model.entity.Terms;
import com.zr.ttappdemo.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuyi
 * @since 2018-10-25
 */
@RestController
@RequestMapping("/terms")
public class TermsController {
    @Autowired
    private TermsService termsService;
    @GetMapping("list")
    public ResultVo list() {
        IPage<Terms> page = new Page<>();
        IPage<Terms> result = termsService.page(page, null);
        PageVo pageVo = new PageVo(page);
        return ResultVo.builder()
                .code(1)
                .msg("查询成功")
                .data(pageVo)
                .build();

    }

}
