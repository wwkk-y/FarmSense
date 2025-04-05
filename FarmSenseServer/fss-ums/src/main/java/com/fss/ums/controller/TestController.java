package com.fss.ums.controller;

import com.fss.ums.service.UmsAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UmsAccountService umsAccountService;

    @GetMapping("/valid")
    public void valid(){
        umsAccountService.registerAccount(null);
    }
}
