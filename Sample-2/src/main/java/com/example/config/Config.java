package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class Config {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${server.error.whitelabel.enabled}")
	private boolean enabled;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddlauto;

	@Value("${spring.jpa.show-sql}")
	private boolean showsql;

	@Value("${spring.jpa.generate-ddl}")
	private boolean generateddl;

	@Value("${spring.jpa.database-platform}")
	private String databasePlatform;

	public String getDatabasePlatform() {
		return databasePlatform;
	}

	public void setDatabasePlatform(String databasePlatform) {
		this.databasePlatform = databasePlatform;
	}

	public String getDdlauto() {
		return ddlauto;
	}

	public void setDdlauto(String ddlauto) {
		this.ddlauto = ddlauto;
	}

	public boolean isShowsql() {
		return showsql;
	}

	public void setShowsql(boolean showsql) {
		this.showsql = showsql;
	}

	public boolean isGenerateddl() {
		return generateddl;
	}

	public void setGenerateddl(boolean generateddl) {
		this.generateddl = generateddl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "{" + url + " , " + username + "}";
	}

}
