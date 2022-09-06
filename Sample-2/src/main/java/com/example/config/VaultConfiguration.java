package com.example.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.VaultCredentials;

@Configuration
public class VaultConfiguration {

	@Autowired
	VaultCredentials vaultCredentials;

	private Logger logger = LoggerFactory.getLogger(VaultConfiguration.class);

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/dbtest");
		logger.info("username: " + vaultCredentials.getDbusername());
		dataSourceBuilder.username(vaultCredentials.getDbusername());
		dataSourceBuilder.password(vaultCredentials.getDbpassword());
		logger.info("username: " + vaultCredentials.getDbusername());
		return dataSourceBuilder.build();
	}

}
