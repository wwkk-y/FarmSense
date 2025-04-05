package com.fss.ums.controller;

import com.github.pagehelper.PageHelper;
import com.fss.common.api.RPage;
import com.fss.common.api.RResult;
import com.fss.ums.service.UmsUserService;
import com.fss.ums.vo.UmsUserVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("用户信息相关接口")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UmsUserService umsUserService;

    @GetMapping("/list")
    public RResult<RPage<UmsUserVo>> list(
            @RequestParam int pageNum,
            @RequestParam int pageSize,
            @RequestParam(required = false) String name // username or nickName
    ){
        PageHelper.startPage(pageNum, pageSize);
        return RResult.success(RPage.restPage(umsUserService.list(name)));
    }
}
