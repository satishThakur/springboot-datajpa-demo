package com.satish.demo.datasource;

import java.util.Properties;

import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component
public class MysqlHikariDataSource extends HikariDataSource{

	public MysqlHikariDataSource(){
		String url = "jdbc:mysql://localhost:3306/demo";
		this.setJdbcUrl(url);
		this.setPoolName("MysqlHikariDataSource");
		this.setRegisterMbeans(true);		
		this.setConnectionTestQuery("SELECT 1");
		this.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");	

		Properties dsProperties = new Properties();
		dsProperties.setProperty("url",url);
		this.setDataSourceProperties(dsProperties );
		
		this.setUsername("root");
		this.setPassword("mysql");
	}

}
