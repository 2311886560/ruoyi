ALTER TABLE examine_item
    ADD COLUMN `auto_status` varchar(2) DEFAULT '1' COMMENT '是否为自动检验：0=自动，1=不自动';
ALTER TABLE examine_item
    ADD COLUMN `max_auto_value` decimal(10, 2) DEFAULT NULL COMMENT '最高自动检验值';
ALTER TABLE examine_item
    ADD COLUMN `min_auto_value` decimal(10, 2) DEFAULT NULL COMMENT '最低自动检验值';



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


