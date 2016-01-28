package com.enxin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enxin.service.SysUserService;

@Controller
@EnableAutoConfiguration
public class SysUserController {
	private static Logger log = LoggerFactory.getLogger(SysUserController.class);  
	
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/hellow")  
    @ResponseBody  
    public String hellow(){  
		log.info("1111111111111111111111111111111111111");
		System.out.println("sysUserService=="+sysUserService);
		sysUserService.getUserList(null);
        return "Spring Boot ！";  
    }  
  
  
}
