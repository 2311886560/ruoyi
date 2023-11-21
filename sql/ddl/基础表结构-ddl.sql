# 商品信息表结构
CREATE TABLE `goods_info`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `ent_id`      bigint(20)          DEFAULT NULL COMMENT '工厂id',
    `name`        varchar(100)        DEFAULT NULL COMMENT '名称',
    `goods_type`  varchar(2)          DEFAULT NULL COMMENT '类型：0-五金，1-化工，2-食品，3-水产',
    `goods_brand` varchar(100)        DEFAULT NULL COMMENT '品牌',
    `cost_price`  double              DEFAULT NULL COMMENT '成本价',
    `sales_price` double              DEFAULT NULL COMMENT '销售价（默认售价）',
    `inventory`   bigint(20)          DEFAULT NULL COMMENT '库存量',
    `status`      varchar(2)          DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    `del_flag`    varchar(2) NOT NULL DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`   varchar(50)         DEFAULT NULL COMMENT '创建人',
    `create_time` datetime            DEFAULT NULL COMMENT '创建日期',
    `update_by`   varchar(50)         DEFAULT NULL COMMENT '更新人',
    `update_time` datetime            DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品信息表';

# 工厂基本信息
CREATE TABLE `enterprise_base`
(
    `id`           bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'id',
    `ent_code`     varchar(45)           DEFAULT NULL COMMENT '工厂编号',
    `credit_code`  varchar(45)           DEFAULT NULL COMMENT '统一信用代码',
    `ent_name`     varchar(512) NOT NULL COMMENT '工厂名称',
    `legal_person` varchar(45)           DEFAULT NULL COMMENT '法人',
    `legal_phone`  varchar(12)           DEFAULT NULL COMMENT '法人手机号',
    `linker_man`   varchar(45)           DEFAULT NULL COMMENT '联系人',
    `linker_phone` varchar(12)           DEFAULT NULL COMMENT '联系电话',
    `work_phone`   varchar(12)           DEFAULT NULL COMMENT '单位联系电话',
    `ent_address`  varchar(256)          DEFAULT NULL COMMENT '公司详细地址',
    `license`      varchar(45)           DEFAULT NULL COMMENT '营业执照号',
    `license_pic`  varchar(128)          DEFAULT NULL COMMENT '营业执照图片地址',
    `remark`       varchar(125)          DEFAULT NULL COMMENT '备注',
    `bus_scope`    varchar(512)          DEFAULT NULL COMMENT '经营范围',
    `status`       varchar(2)            DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    `del_flag`     varchar(2)   NOT NULL DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`    varchar(50)           DEFAULT NULL COMMENT '创建人',
    `create_time`  datetime              DEFAULT NULL COMMENT '创建日期',
    `update_by`    varchar(50)           DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime              DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='工厂基本信息';

# 商品订单主表
CREATE TABLE `goods_order`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单主表id',
    `order_code`     varchar(100) DEFAULT NULL COMMENT '订单编号',
    `order_title`    varchar(100) DEFAULT NULL COMMENT '订单标题',
    `saler_ent_id`   bigint(20)   DEFAULT NULL COMMENT '卖方企业',
    `buyer_user_id`  bigint(20)   DEFAULT NULL COMMENT '买方员工',
    `saler_user_id`  bigint(20)   DEFAULT NULL COMMENT '卖方员工',
    `order_time`   datetime     DEFAULT NULL COMMENT '订单时间',
    `confirm_time`   datetime     DEFAULT NULL COMMENT '确认时间',
    `logistics_code` varchar(100) DEFAULT NULL COMMENT '物流编号',
    `status`         char(1)    DEFAULT '0' COMMENT '0待完成；1已完成，9拒绝',
    `del_flag`       varchar(2)   DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`      varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建日期（下单时间）',
    `update_by`      varchar(50)  DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品订单主表';

# 商品订单子表
CREATE TABLE `goods_order_sub`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
    `order_id`     bigint(20) NOT NULL COMMENT '订单主表id',
    `goods_id`     bigint(20) NOT NULL COMMENT '商品id',
    `order_amount` double      DEFAULT NULL COMMENT '数量',
    `sales_price`  double      DEFAULT NULL COMMENT '销售价',
    `total_price`  double      DEFAULT NULL COMMENT '总价',
    `status`       varchar(2)  DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    `del_flag`     varchar(2)  DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    `create_by`    varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`  datetime    DEFAULT NULL COMMENT '创建日期',
    `update_by`    varchar(50) DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品订单子表';
