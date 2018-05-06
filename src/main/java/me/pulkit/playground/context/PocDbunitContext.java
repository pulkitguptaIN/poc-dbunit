package me.pulkit.playground.context;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import me.pulkit.playground.persister.EmployeePersister;
import me.pulkit.playground.service.EmployeeService;
import me.pulkit.playground.service.impl.EmployeeServiceImpl;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/app.properties")
public class PocDbunitContext {

	@Bean
	public DataSource getDataSource(@Value("${jdbc.driver.class.name}") String driverClassName,
			@Value("${jdbc.url}") String url, @Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

	@Bean
	public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}

	@Bean
	public MapperFactoryBean<EmployeePersister> getEmployeePersister(SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<EmployeePersister> employeePersister = new MapperFactoryBean<EmployeePersister>(
				EmployeePersister.class);
		employeePersister.setSqlSessionFactory(sqlSessionFactory);
		return employeePersister;
	}

}
