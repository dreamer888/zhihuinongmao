package com.wqwy.zhnm.base.component.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:applications-infrastructure-component.properties", "classpath:mallbase-component-amqp.properties", "classpath:mallbase-component-redis.properties"})
public class ComponentConfig {
	
	@Bean
	public ComponentProperties getComponentProperties() {
		return new ComponentProperties();
	}
	
	@Bean
	@Qualifier("sellerConnectionFactory")
	@Primary
	public ConnectionFactory lawstoreConnectionFactory(ComponentProperties componentProperties) {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(componentProperties.getAmqp().getRabbitmqHost());
		connectionFactory.setPort(componentProperties.getAmqp().getRabbitmqPort());
		connectionFactory.setUsername(componentProperties.getAmqp().getRabbitmqUsername());
		connectionFactory.setPassword(componentProperties.getAmqp().getRabbitmqPassword());
		connectionFactory.setVirtualHost(componentProperties.getAmqp().getRabbitmqSellerVirtualHost());
		connectionFactory.setChannelCacheSize(100); 
		return connectionFactory;
	}
	
	/*
	 * define exchanges
	 */
	// topic exchange for balance&seller
	public final static String BalanceTopicExchange = "balance-topic-exchange";
	public final static String SellerTopicExchange = "seller-topic-exchange";
	public final static String DelivererTopicExchange = "deliverer-topic-exchange";
	
	@Bean
	@Qualifier("balanceTopicExchange")
	public TopicExchange getBalanceTopicExchange() {
		return new TopicExchange(BalanceTopicExchange);
	}
	
	@Bean
	@Qualifier("sellerTopicExchange")
	public TopicExchange getSellerTopicExchange() {
		return new TopicExchange(SellerTopicExchange);
	}
	
	@Bean
	@Qualifier("delivererTopicExchange")
	public TopicExchange getDelivererTopicExchange() {
		return new TopicExchange(SellerTopicExchange);
	}
	
	@Bean
	public RabbitAdmin getRabbitAdmin(ConnectionFactory connectionFactory) {
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		TopicExchange exchange1 = new TopicExchange(BalanceTopicExchange);
		TopicExchange exchange2 = new TopicExchange(SellerTopicExchange);
		TopicExchange exchange3 = new TopicExchange(DelivererTopicExchange);
		admin.declareExchange(exchange1);
		admin.declareExchange(exchange2);
		admin.declareExchange(exchange3);
		
		Queue queue1 = new Queue("defaultQueue");
		admin.declareQueue(queue1);
		Queue queue2 = new Queue("defaultQueue");
		admin.declareQueue(queue2);
		Queue queue3 = new Queue("defaultQueue");
		admin.declareQueue(queue3);
		admin.declareBinding(BindingBuilder.bind(queue1).to(exchange1).with("default.*"));
		admin.declareBinding(BindingBuilder.bind(queue2).to(exchange2).with("default.*"));
		admin.declareBinding(BindingBuilder.bind(queue2).to(exchange3).with("default.*"));
		
		return admin;
	}
	
	@Bean
	public RabbitTemplate getRabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		return template;
	}
	
}
