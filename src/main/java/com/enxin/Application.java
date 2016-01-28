package com.enxin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.enxin.service.SysUserService;

@Configuration//配置控制  
@EnableAutoConfiguration  //启用自动配置  
@ComponentScan  //组件扫描  
public class Application implements CommandLineRunner{
    public static void main( String[] args ){
    	SpringApplication.run(Application.class, args);
//    	System.out.println();
    }

	public void run(String... arg0) throws Exception {
		System.out.println("这是一个整合MyBatis和Spring-Boot整合的Demo");
	}
}
