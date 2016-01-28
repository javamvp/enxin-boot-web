package com.enxin.conf.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@EnableAutoConfiguration
@AutoConfigureAfter({DataBaseConfiguration.class,MyBatisConfiguration.class})
public class MapperScannerConfig implements EnvironmentAware{
	private RelaxedPropertyResolver propertyResolver;
	
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");  
	}
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage(propertyResolver.getProperty("basePackage"));
		
		System.out.println("mapperScannerConfigurer===="+mapperScannerConfigurer);
		return mapperScannerConfigurer;
	}
}
