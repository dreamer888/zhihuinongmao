package com.wqwy.zhnm.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.wqwy.zhnm.base.component.config.ComponentConfig;
import com.wqwy.zhnm.base.dao.config.MallBaseDaoMapperConfig;
import com.wqwy.zhnm.base.service.config.TransactionConfig;

@SpringBootApplication
@ComponentScan(basePackages="com.wqwy.zhnm")
@Import({MallBaseDaoMapperConfig.class, TransactionConfig.class, ComponentConfig.class})
public class MalldeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalldeliveryApplication.class, args);
	}
}
