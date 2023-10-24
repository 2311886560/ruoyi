ALTER TABLE sys_user
    ADD COLUMN `id_card` varchar(50) DEFAULT NULL COMMENT '身份证号码';
ALTER TABLE sys_user
    ADD COLUMN `birthday_date` datetime DEFAULT NULL COMMENT '生日';
ALTER TABLE sys_user
    ADD COLUMN `ent_id` bigint(20) DEFAULT NULL COMMENT '工厂id';
-- 程序目录和数据最后再一起导出
