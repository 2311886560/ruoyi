INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (5, '生活用品', '4', 'sys_goods_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '生活用品');


INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`,
                                                `update_by`, `update_time`, `remark`)
VALUES ('生产状态', 'sys_goods_order_produce_status', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '生产状态列表');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1, '未开始', '0', 'sys_goods_order_produce_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2, '加工', '1', 'sys_goods_order_produce_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (3, '组装', '2', 'sys_goods_order_produce_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (4, '质检', '3', 'sys_goods_order_produce_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (5, '包装', '4', 'sys_goods_order_produce_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`,
                                                `css_class`, `list_class`, `is_default`, `status`, `create_by`,
                                                `create_time`, `update_by`, `update_time`, `remark`)
VALUES (6, '生产完成', '5', 'sys_goods_order_produce_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
