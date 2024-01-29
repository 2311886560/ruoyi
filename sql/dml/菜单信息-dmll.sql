INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1061, '干休所列表', 0, 1, 'retired', 'examine/retired/index', NULL, 1, 0, 'C', '0', '0', '', 'peoples', 'admin',
        '2023-10-24 00:05:12', 'admin', '2024-01-13 19:07:57', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1062, '医院列表', 0, 1, 'hospital', 'examine/hospital/index', NULL, 1, 0, 'C', '0', '0', '', 'cascader',
        'admin', '2023-10-24 00:05:12', 'admin', '2024-01-13 19:08:04', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1063, '体检项目', 0, 2, 'examineItem', 'examine/examineItem/index', NULL, 1, 0, 'C', '0', '0', '', 'tab',
        'admin', '2023-10-24 00:05:12', 'admin', '2024-01-13 19:23:30', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`,
                                           `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`,
                                           `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (1064, '体检数据', 0, 2, 'examinePhysical', 'examine/examinePhysical/index', NULL, 1, 0, 'C', '0', '0', '',
        'table', 'admin', '2023-10-24 00:05:12', 'admin', '2024-01-13 19:23:43', '');
