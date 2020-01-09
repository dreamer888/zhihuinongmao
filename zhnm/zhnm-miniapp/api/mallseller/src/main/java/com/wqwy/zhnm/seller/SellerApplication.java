package com.wqwy.zhnm.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wqwy.zhnm.base.component.config.ComponentConfig;
import com.wqwy.zhnm.base.dao.config.MallBaseDaoMapperConfig;
import com.wqwy.zhnm.base.service.config.TransactionConfig;

//@SpringBootApplication
//@MapperScan("com.wqwy.zhnm.seller.dao")
@EnableScheduling
//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages="com.wqwy.zhnm")
@Import({MallBaseDaoMapperConfig.class, TransactionConfig.class, ComponentConfig.class})
public class SellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerApplication.class, args);
	}
}
