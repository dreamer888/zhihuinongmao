#######Wed_May_30_16_14_24_HKT_2018
alter table deliverer_bank_account add account_phone varchar(17) default null comment '银行卡预留手机号码';

#######
CREATE TABLE third_part_notify (
  `id` int(11) not null AUTO_INCREMENT,
  trade_no varchar(50) NOT NULL comment '第三方交易回调商户系统内部订单号',
  notify_type enum('WECHAT', 'ALIPAY') not null comment 'notify类型',
  operation_type enum('QR_PAY') not null comment '操作类型',
  notify_status int(3) not null comment 'notify状态 1.创建 3.成功 5.失败 (第三方支付notify可能为失败)',
  notify_time datetime default null comment 'notify时间,有时间说明notify已经发生',
  create_time datetime comment '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '第三方支付notify';