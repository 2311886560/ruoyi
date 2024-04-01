-- 是否为自动检验
INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES ('是否为自动检验', 'examine_item_auto_status', '0', 'admin', '2023-11-11 18:28:13', 'admin',
        '2023-11-11 18:28:22', '是否为自动检验列表');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (1, '自动', '0', 'examine_item_auto_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (2, '不自动', '1', 'examine_item_auto_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');
-- 审核状态
INSERT INTO `sys_dict_type` (`dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES ('审核状态', 'examine_physical_auth_status', '0', 'admin', '2023-11-11 18:28:13', 'admin',
        '2023-11-11 18:28:22', '审核状态列表');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (1, '审核通过', '0', 'examine_physical_auth_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');
INSERT INTO `sys_dict_data` (`dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                             `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                             `update_time`, `remark`)
VALUES (2, '审核不通过', '1', 'examine_physical_auth_status', NULL, 'default', 'N', '0', 'admin', '2023-11-11 18:29:12',
        'admin', '2023-11-11 18:29:17', '');


