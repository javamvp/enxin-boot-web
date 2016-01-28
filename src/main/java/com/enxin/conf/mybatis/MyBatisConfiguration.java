package com.enxin.conf.mybatis;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//上面代码创建了一个SqlSessionFactory和一个SqlSessionTemplate，为了支持注解事务，
//增加了@EnableTransactionManagement注解，并且反回了一个PlatformTransactionManagerBean。

@Configuration  
@EnableTransactionManagement
@EnableAutoConfiguration
//由于先需要加载datasource所以这个必须在DataBaseConfiguration 执行
@AutoConfigureAfter({DataBaseConfiguration.class})
public class MyBatisConfiguration implements EnvironmentAware,TransactionManagementConfigurer{
	private RelaxedPropertyResolver propertyResolver;

	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");  
	}
	
	@Resource(name="dataSource")
    private DataSource dataSource;  
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(){
		try {  
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			//配置mybatis自动加载配置
			System.out.println("dataSource=="+dataSource);
			
			bean.setDataSource(dataSource);
			bean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
			bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapperLocations")));
			bean.setConfigLocation(new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));
			System.out.println("sqlSessionFactory=="+bean.getObject());
	        return bean.getObject();
		}catch(Exception e){
			e.printStackTrace();
//			logger.warn("Could not confiure mybatis session factory");  
		}
		return null;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
