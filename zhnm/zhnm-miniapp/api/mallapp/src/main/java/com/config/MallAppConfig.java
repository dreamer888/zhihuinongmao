package com.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(value={"com.yq.service"}, sqlSessionTemplateRef  = "sqlSessionTemplate")
public class MallAppConfig {

	@Autowired
	public DataSource mysqlDataSource;
	
	@Bean(name = "sqlSessionFactoryApp")
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
            bean.setMapperLocations(resolver.getResources("classpath:/mybatis/*/*.xml"));
            bean.setConfigLocation(resolver.getResource("classpath:/mybatis/mybatis-config.xml"));
            
//            org.apache.ibatis.session.Configuration c = new org.apache.ibatis.session.Configuration();
//            c.setCallSettersOnNulls(true);//set key even if value==null
////            c.addMappers("com.wqwy.zhnm.base.dao");
////            c.
//            bean.setConfiguration(c);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	
	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactoryApp") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public StringHttpMessageConverter getStringHttpMessageConverter() {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")));
		supportedMediaTypes.add(new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8")));
		stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		return stringHttpMessageConverter;
	}
	
	@Bean
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(104857600L);
		commonsMultipartResolver.setMaxInMemorySize(4096);
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		return commonsMultipartResolver;
	}
	
}
