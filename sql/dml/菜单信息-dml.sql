INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`,
                        `dept_check_strictly`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`,
                        `update_time`, `remark`)
VALUES (3, '医务人员', 'examine_admin', 3, '1', 1, 1, '0', '0', 'admin', '2024-01-27 14:48:17', '', NULL, NULL);
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`,
                        `dept_check_strictly`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`,
                        `update_time`, `remark`)
VALUES (4, '医务数据管理人员', 'examine_physical_user', 4, '1', 1, 1, '0', '0', 'admin', '2024-01-27 14:48:58', '',
        NULL, NULL);
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`,
                        `dept_check_strictly`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`,
                        `update_time`, `remark`)
VALUES (5, '退休老干部', 'retired_user', 5, '1', 1, 1, '0', '0', 'admin', '2024-01-27 14:49:23', '', NULL, NULL);

INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 100);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1000);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1001);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1002);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1003);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1004);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1005);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1006);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1061);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1062);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1063);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (3, 1064);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (4, 1063);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (4, 1064);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (5, 1064);



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
