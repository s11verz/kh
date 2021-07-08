package com.kh.spring23.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {
//	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
//		<property name="dataSource" ref="dbcpSource"></property>
//		<property name="configLocation" value="classpath:/mybatis/mybatis-config.xml"></property>
//		<property name="mapperLocations" value="classpath:/mybatis/mapper/**/*-mapper.xml"></property>
//	</bean>
	
//	ApplicationContext는 Spring에서 제공하는 경로 탐색 도구
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(
			DataSource dbcpSource, ApplicationContext context) throws IOException {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dbcpSource);
		factory.setConfigLocation(context.getResource("classpath:/mybatis/mybatis-config.xml"));
		factory.setMapperLocations(context.getResources("classpath:/mybatis/mapper/**/*-mapper.xml"));
		return factory;
	}
	
	
//	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
//		<constructor-arg index="0" ref="factory"></constructor-arg>
//	</bean>
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
		return template;
	}
	
}
