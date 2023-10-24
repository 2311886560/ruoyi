CREATE TABLE `goods_order`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单主表id',
    `order_code`     varchar(100) NOT NULL COMMENT '订单编号',
    `saler_ent_id`   bigint(20) NOT NULL COMMENT '卖方企业',
    `buyer_user_id`  bigint(20) DEFAULT NULL COMMENT '买方员工',
    `saler_user_id`  bigint(20) DEFAULT NULL COMMENT '卖方员工',
    `confirm_time`   datetime              DEFAULT NULL COMMENT '确认时间',
    `logistics_code` varchar(100) NOT NULL COMMENT '物流编号',
    `status`         char(1)      NOT NULL COMMENT '0待完成；1已完成，9拒绝',
    `del_flag`       varchar(2)   NOT NULL DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`      varchar(50)           DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime              DEFAULT NULL COMMENT '创建日期',
    `update_by`      varchar(50)           DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime              DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='商品订单主表';

CREATE TABLE `goods_order_sub`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
    `order_id`     bigint(20) NOT NULL COMMENT '订单主表id',
    `goods_id`     bigint(20) NOT NULL COMMENT '商品id',
    `order_amount` double     NOT NULL COMMENT '数量',
    `sales_price`   double              DEFAULT NULL COMMENT '销售价',
    `total_price`   double              DEFAULT NULL COMMENT '总价',
    `status`       varchar(2)          DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    `del_flag`     varchar(2) NOT NULL DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`    varchar(50)         DEFAULT NULL COMMENT '创建人',
    `create_time`  datetime            DEFAULT NULL COMMENT '创建日期',
    `update_by`    varchar(50)         DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime            DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='商品订单子表';
