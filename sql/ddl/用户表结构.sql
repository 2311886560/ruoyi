ALTER TABLE sys_user
    ADD COLUMN `id_card` varchar(50) DEFAULT NULL COMMENT '身份证号码';
ALTER TABLE sys_user
    ADD COLUMN `birthday_date` datetime DEFAULT NULL COMMENT '生日';
ALTER TABLE sys_user
    ADD COLUMN `ent_id` bigint(20) DEFAULT NULL COMMENT '工厂id';
-- 程序目录和数据最后再一起导出
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1061, '库存管理', 0, 0, 'goodsInfo', NULL, NULL, 1, 0, 'M', '0', '0', '', 'date', 'admin',
        '2023-10-24 00:04:34', 'admin', '2023-10-24 00:05:29', '');
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1062, '库存列表', 1061, 1, 'goodsInfo', 'factory/goodsInfo/index', NULL, 1, 0, 'C', '0', '0', '', 'list',
        'admin', '2023-10-24 00:05:12', 'admin', '2023-10-24 00:12:35', '');
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1063, '工厂管理', 0, 0, 'enterpriseBase', NULL, NULL, 1, 0, 'M', '0', '0', '', 'date', 'admin',
        '2023-10-24 00:04:34', 'admin', '2023-10-24 00:05:29', '');
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1064, '工厂列表', 1063, 1, 'enterpriseBase', 'factory/enterpriseBase/index', NULL, 1, 0, 'C', '0', '0', '',
        'list', 'admin', '2023-10-24 00:05:12', 'admin', '2023-10-24 00:12:35', '');
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1065, '订单管理', 0, 0, 'goodsOrder', NULL, NULL, 1, 0, 'M', '0', '0', '', 'date', 'admin',
        '2023-10-24 00:04:34', 'admin', '2023-10-24 00:05:29', '');
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1066, '订单列表', 1065, 1, 'goodsOrder', 'factory/goodsOrder/index', NULL, 1, 0, 'C', '0', '0', '',
        'list', 'admin', '2023-10-24 00:05:12', 'admin', '2023-10-24 00:12:35', '');

