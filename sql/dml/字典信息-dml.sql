INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (11, '用户类型', 'sys_user_type', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '用户类型列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (12, '体检项默认状态', 'examine_item_default_status', '0', 'admin', '2023-11-11 18:28:13', 'admin',
        '2023-11-11 18:28:22', '体检项默认状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (13, '个人中心状态', 'examine_item_show_user', '0', 'admin', '2023-11-11 18:28:13', 'admin',
        '2023-11-11 18:28:22', '个人中心状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (14, '性别推荐状态', 'examine_item_sex_status', '0', 'admin', '2023-11-11 18:28:13', 'admin',
        '2024-01-27 15:41:02', '性别推荐状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (15, '体检审核状态', 'examine_physical_process_status', '0', 'admin', '2023-11-11 18:28:13', 'admin',
        '2023-11-11 18:28:22', '体检审核状态列表');

INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (30, 1, '系统用户', '00', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '系统后台用户');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (31, 2, '医务人员', '10', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2024-01-14 23:14:41', '医务人员');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (32, 3, '医务数据管理人员', '11', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2024-01-14 23:14:48', '医务数据管理人员');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (33, 4, '退休老干部', '21', 'sys_user_type', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2024-01-14 23:14:55', '退休老干部');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (34, 5, '系统用户', '99', 'sys_user_type', NULL, 'default', 'N', '1', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '系统用户（暂不使用）');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (35, 1, '默认显示', '0', 'examine_item_default_status', NULL, 'default', 'N', '0', 'admin',
        '2023-11-11 18:29:12', 'admin', '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (36, 2, '不默认', '2', 'examine_item_default_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (37, 1, '显示个人中心', '0', 'examine_item_show_user', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (38, 2, '不显示', '2', 'examine_item_show_user', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (39, 1, '男', '0', 'examine_item_sex_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (40, 2, '女', '1', 'examine_item_sex_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (41, 3, '无', '2', 'examine_item_sex_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2024-01-27 15:40:50', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (42, 1, '未审核', '0', 'examine_physical_process_status', NULL, 'info', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2024-01-20 14:05:21', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (43, 2, '审核通过', '1', 'examine_physical_process_status', NULL, 'success', 'N', '0', 'admin',
        '2023-11-11 18:29:12', 'admin', '2024-01-20 14:05:11', '');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (44, 3, '审核不通过', '2', 'examine_physical_process_status', NULL, 'danger', 'N', '0', 'admin',
        '2023-11-11 18:29:12', 'admin', '2024-01-20 14:05:18', '');

