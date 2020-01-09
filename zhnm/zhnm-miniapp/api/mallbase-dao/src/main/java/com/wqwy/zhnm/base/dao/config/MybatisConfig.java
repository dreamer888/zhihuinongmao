package com.wqwy.zhnm.base.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(value={"com.wqwy.zhnm.base.dao"}, sqlSessionFactoryRef="mybatisSqlSessionFactory")
//@AutoConfigureBefore(MallBaseDaoMapperConfig.class)
public class MybatisConfig {

	/**
	 * 
	 * @Title: sqlSessionFactoryBean  
	 * @Description: mybatis 相关配置  
	 * @date 15 May 2018 12:24:23 PM  
	 * @param @param dataSource
	 * @param @return  
	 * @return SqlSessionFactory  
	 * @throws
	 */
	@Bean(name = "mybatisSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("mysqlDataSource") DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setTypeAliasesPackage("com.wqwy.zhnm.base.entity");

        //configure plugin
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //add plugin
        bean.setPlugins(new Interceptor[]{pageHelper});
        //add xml location
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:/mybatis-base-dao/mapper/*.xml"));
            
            org.apache.ibatis.session.Configuration c = new org.apache.ibatis.session.Configuration();
            c.setCallSettersOnNulls(true);//set key even if value==null
//            c.addMappers("com.wqwy.zhnm.base.dao");
            bean.setConfiguration(c);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	
}
