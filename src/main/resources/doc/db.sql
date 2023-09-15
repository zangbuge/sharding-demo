# 分别在 sharding-order , sharding-order1 两个库创建 t_order_1, t_order_2 表
CREATE TABLE `t_order_1` (
  `id` int(11) NOT NULL,
  `order_amount` decimal(10,2) NOT NULL COMMENT '订单金额',
  `order_status` int(1) NOT NULL COMMENT '订单状态',
  `user_id` int(11) NOT NULL COMMENT '用户 iD',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 库表如下
01:
sharding-order
	t_order_1
    t_order_2

02:
sharding-order1
	t_order_1
  	t_order_2