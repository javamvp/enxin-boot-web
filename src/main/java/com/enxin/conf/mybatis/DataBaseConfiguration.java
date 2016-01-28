package com.enxin.conf.mybatis;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration  
@EnableAutoConfiguration
public class DataBaseConfiguration implements EnvironmentAware{
	 private RelaxedPropertyResolver propertyResolver;
	 
	 public void setEnvironment(Environment environment) {
		 this.propertyResolver = new RelaxedPropertyResolver(environment,"jdbc.");  
	 }  
	 
	 @Bean(name="dataSource")  
	 public DataSource readOneDataSource() {  
		 try {
			
		
//	        log.debug("Configruing Read One DataSource");  
	        DruidDataSource datasource = new DruidDataSource();  
	        datasource.setUrl(propertyResolver.getProperty("url"));  
	        System.out.println("url=="+propertyResolver.getProperty("url"));
	        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));  
	        datasource.setUsername(propertyResolver.getProperty("username"));  
	        datasource.setPassword(propertyResolver.getProperty("password")); 
	        System.out.println("datasource=="+datasource);
	        return datasource;  
		 } catch (Exception e) {
			 e.printStackTrace();
				// TODO: handle exception
			}
		 return null;
	    }

}
