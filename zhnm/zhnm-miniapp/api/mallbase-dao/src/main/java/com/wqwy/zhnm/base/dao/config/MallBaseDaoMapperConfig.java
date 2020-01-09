package com.wqwy.zhnm.base.dao.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:applications-infrastructure-dao.properties", "classpath:mallbase-dao-datasource.properties"})
@AutoConfigureBefore(MybatisConfig.class)
public class MallBaseDaoMapperConfig {
	
	@Bean(name="primaryDataSourceProperties")
	@Primary
	@ConfigurationProperties("wqwy.zhnm.datasource.primary")
	public DataSourceProperties primaryDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean(name="mysqlDataSource")
	@Primary
	@ConfigurationProperties("wqwy.zhnm.datasource.primary")
	public DataSource primaryDataSource() {
	    return primaryDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	//quartz datasource
	@Bean(name="quartzDataSourceProperties")
	@ConfigurationProperties("wqwy.zhnm.datasource.quartz")
	public DataSourceProperties quartzDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean(name="quartzDataSource")
	@ConfigurationProperties("wqwy.zhnm.datasource.quartz")
	public DataSource quartzDataSource() {
	    return quartzDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	
//	@Bean("mybatisSqlSessionTemplate")
//	public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("mybatisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
}
