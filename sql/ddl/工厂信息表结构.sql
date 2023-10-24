CREATE TABLE `enterprise_base`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='工厂基本信息';
-- 程序目录和数据最后再一起导出
