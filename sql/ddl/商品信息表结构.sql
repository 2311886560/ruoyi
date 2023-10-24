CREATE TABLE `goods_info`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `ent_id`      bigint(20) DEFAULT NULL COMMENT '工厂id',
    `name`        varchar(100)        DEFAULT NULL COMMENT '名称',
    `goods_type`  varchar(2)          DEFAULT NULL COMMENT '类型：0-五金，1-化工，2-食品，3-水产',
    `goods_brand` varchar(100)        DEFAULT NULL COMMENT '品牌',
    `cost_price`  double              DEFAULT NULL COMMENT '成本价',
    `sales_price`  double              DEFAULT NULL COMMENT '销售价（默认售价）',
    `inventory`   bigint(20) DEFAULT NULL COMMENT '库存量',
    `status`      varchar(2)          DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    `del_flag`    varchar(2) NOT NULL DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`   varchar(50)         DEFAULT NULL COMMENT '创建人',
    `create_time` datetime            DEFAULT NULL COMMENT '创建日期',
    `update_by`   varchar(50)         DEFAULT NULL COMMENT '更新人',
    `update_time` datetime            DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';

-- 程序目录和数据最后再一起导出
