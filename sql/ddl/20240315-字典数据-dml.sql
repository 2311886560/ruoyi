
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (4, '完成', '2', 'sys_goods_order_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (5, '退货', '10', 'sys_goods_order_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');



INSERT INTO `sys_menu` (`menu_name`, `parent_id`, `order_num`, `path`, `component`,
                        `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                        `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES ('商品库存预警', 0, 0, 'goodsInfoWarn', 'factory/goodsInfoWarn/index', NULL, 1, 0, 'C', '0', '0', '',
        'list', 'admin', '2023-10-24 00:05:12', 'admin', '2023-10-24 00:12:35', '');
