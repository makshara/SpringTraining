package com.spring.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.spring.training")
public class SpringJdbcConfig {
	@Value(value = "${spring.datasource.driverClassName}")
	String className;
	@Value(value = "${spring.datasource.url}")
	String url;
	@Value(value = "${spring.datasource.username}")
	String userName;
	@Value(value = "${spring.datasource.password}")
	String password;
	@Bean
    public DriverManagerDataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(className);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }
}
