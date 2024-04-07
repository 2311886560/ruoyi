-- 商品订单消息表
CREATE TABLE `goods_order_message`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
    `order_id`        bigint(20) NOT NULL COMMENT '订单主表id',
    `user_id`         bigint(20)   DEFAULT NULL COMMENT '用户id',
    `user_name`       varchar(50)  DEFAULT NULL COMMENT '用户名称',
    `message_content` varchar(256) DEFAULT NULL COMMENT '消息内容',
    `status`          varchar(2)   DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    `del_flag`        varchar(2)   DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`       varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建日期',
    `update_by`       varchar(50)  DEFAULT NULL COMMENT '更新人',
    `update_time`     datetime     DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品订单消息表';
