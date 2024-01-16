INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES ('性别限制状态', 'examine_item_sex_status', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '性别限制状态列表');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (1, '男', '0', 'examine_item_sex_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (2, '女', '1', 'examine_item_sex_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (3, '无限制', '2', 'examine_item_sex_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES ('体检项默认状态', 'examine_item_default_status', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '体检项默认状态列表');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (1, '默认显示', '0', 'examine_item_default_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (2, '不默认', '1', 'examine_item_default_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');


INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES ('个人中心状态', 'examine_item_show_user', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '个人中心状态列表');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (1, '显示个人中心', '0', 'examine_item_show_user', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (2, '不显示', '1', 'examine_item_show_user', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');


INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES ('体检审核状态', 'examine_physical_process_status', '0', 'admin', '2023-11-11 18:28:13', 'admin', '2023-11-11 18:28:22',
        '体检审核状态列表');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (1, '未审核', '0', 'examine_physical_process_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (2, '审核通过', '1', 'examine_physical_process_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (3, '审核不通过', '2', 'examine_physical_process_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12', 'admin',
        '2023-11-11 18:29:17', '');

