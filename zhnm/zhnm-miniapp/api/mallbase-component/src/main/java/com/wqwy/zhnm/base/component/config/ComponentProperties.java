package com.wqwy.zhnm.base.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wqwy.zhnm.component", ignoreUnknownFields = false)
public class ComponentProperties {
	
	private Amqp amqp = new Amqp();
	
	private Async async = new Async();
	
	private Redis redis = new Redis();
	
	public Amqp getAmqp() {
		return amqp;
	}

	public void setAmqp(Amqp amqp) {
		this.amqp = amqp;
	}

	public Async getAsync() {
		return async;
	}

	public void setAsync(Async async) {
		this.async = async;
	}

	public Redis getRedis() {
		return redis;
	}

	public void setRedis(Redis redis) {
		this.redis = redis;
	}

	public static class Async {

        private int corePoolSize = 2;

        private int maxPoolSize = 50;

        private int queueCapacity = 10000;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }
	
	public static class Amqp {
		
		private String rabbitmqHost;
		
		private int rabbitmqPort;
		
		private String rabbitmqUsername;
		
		private String rabbitmqPassword;
		
		private String rabbitmqSellerVirtualHost;
		
		private Client client;

		public String getRabbitmqHost() {
			return rabbitmqHost;
		}

		public void setRabbitmqHost(String rabbitmqHost) {
			this.rabbitmqHost = rabbitmqHost;
		}

		public int getRabbitmqPort() {
			return rabbitmqPort;
		}

		public void setRabbitmqPort(int rabbitmqPort) {
			this.rabbitmqPort = rabbitmqPort;
		}

		public String getRabbitmqUsername() {
			return rabbitmqUsername;
		}

		public void setRabbitmqUsername(String rabbitmqUsername) {
			this.rabbitmqUsername = rabbitmqUsername;
		}

		public String getRabbitmqPassword() {
			return rabbitmqPassword;
		}

		public void setRabbitmqPassword(String rabbitmqPassword) {
			this.rabbitmqPassword = rabbitmqPassword;
		}

		public String getRabbitmqSellerVirtualHost() {
			return rabbitmqSellerVirtualHost;
		}

		public void setRabbitmqSellerVirtualHost(String rabbitmqSellerVirtualHost) {
			this.rabbitmqSellerVirtualHost = rabbitmqSellerVirtualHost;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public static class Client {
			
			private String rabbitmqUsername;
			
			private String rabbitmqPassword;

			public String getRabbitmqUsername() {
				return rabbitmqUsername;
			}

			public void setRabbitmqUsername(String rabbitmqUsername) {
				this.rabbitmqUsername = rabbitmqUsername;
			}

			public String getRabbitmqPassword() {
				return rabbitmqPassword;
			}

			public void setRabbitmqPassword(String rabbitmqPassword) {
				this.rabbitmqPassword = rabbitmqPassword;
			}
			
		}
	}
	
	public static class Redis {
		
		private String hostname;
		
		private int port;
		
		private int database;// 考虑多个
		
		private String password;

		public String getHostname() {
			return hostname;
		}

		public void setHostname(String hostname) {
			this.hostname = hostname;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public int getDatabase() {
			return database;
		}

		public void setDatabase(int database) {
			this.database = database;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	}

}
