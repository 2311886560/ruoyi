INSERT INTO `factory_database`.`sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`,
                                                `update_by`, `update_time`, `remark`)
VALUES ('用户类型', 'sys_user_type', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '用户类型列表');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1, '系统用户', '00', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '系统后台用户');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2, '工厂负责人', '10', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '工厂负责人');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (3, '工厂订单管理员', '11', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '工厂订单管理员');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (4, '工厂客户', '21', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '工厂客户');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (5, '系统用户', '99', 'sys_user_type', NULL, 'default', 'N', '1', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '系统用户（暂不使用）');

INSERT INTO `factory_database`.`sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`,
                                                `update_by`, `update_time`, `remark`)
VALUES ('商品类型', 'sys_goods_type', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '商品类型列表');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1, '五金', '0', 'sys_goods_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '五金');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2, '化工', '1', 'sys_goods_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '化工');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (3, '食品', '2', 'sys_goods_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '食品');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (4, '水产', '3', 'sys_goods_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '水产');

INSERT INTO `factory_database`.`sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`,
                                                `update_by`, `update_time`, `remark`)
VALUES ('订单状态', 'sys_goods_order_status', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '订单状态列表');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1, '待完成', '0', 'sys_goods_order_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2, '已完成', '1', 'sys_goods_order_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `factory_database`.`sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (3, '拒绝', '9', 'sys_goods_order_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

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
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1067, '订单财务报表', 1065, 1, 'goodsOrderForm', 'factory/goodsOrderForm/index', NULL, 1, 0, 'C', '0', '0', '',
        'list', 'admin', '2023-10-24 00:05:12', 'admin', '2023-10-24 00:12:35', '');
INSERT INTO `factory_database`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1068, '订单统计', 1065, 1, 'goodsOrderInfo', 'factory/statistics/goodsOrderInfo/index', NULL, 1, 0, 'C', '0', '0', '',
        'list', 'admin', '2023-10-24 00:05:12', 'admin', '2023-10-24 00:12:35', '');

