ALTER TABLE sys_user
    ADD COLUMN `id_card` varchar(50) DEFAULT NULL COMMENT '身份证号码';
ALTER TABLE sys_user
    ADD COLUMN `birthday_date` datetime DEFAULT NULL COMMENT '生日';
ALTER TABLE sys_user
    ADD COLUMN `ent_id` bigint(20) DEFAULT NULL COMMENT '工厂id';

INSERT INTO `sys_user` (`user_id`, `dept_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `id_card`, `birthday_date`, `ent_id`) VALUES (3, NULL, '测试南宁工厂负责人', 'ceshi1024', '10', '11111@qq.com', '18169761111', '0', '', '$2a$10$p8epgG5e/TOq2dBOZzwEq.S3T/Uh54MFd51FjEksSht15CZezGlgK', '0', '0', '127.0.0.1', '2023-11-11 20:05:37', 'admin', '2023-10-24 17:04:25', 'admin', '2023-11-11 20:05:37', NULL, NULL, NULL, 1);
INSERT INTO `sys_user` (`user_id`, `dept_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `id_card`, `birthday_date`, `ent_id`) VALUES (4, NULL, '测试南宁工厂订单管理员', 'ceshi1024', '11', '231188@qq.com', '18166666666', '2', '', '$2a$10$8DJouIVrcCREm2pcEprxU.Vvwgll3438Pp9LrZzPmgGmeVz.HsfIG', '0', '0', '127.0.0.1', '2023-11-11 13:12:34', 'admin', '2023-10-24 17:06:12', 'admin', '2023-11-11 18:41:36', NULL, '16556546', NULL, 1);

INSERT INTO `enterprise_base` (`id`, `ent_code`, `credit_code`, `ent_name`, `legal_person`, `legal_phone`, `linker_man`, `linker_phone`, `work_phone`, `ent_address`, `license`, `license_pic`, `remark`, `bus_scope`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'Nodadsad', '16515165131561', '南宁工厂', '法人代表', '18155616615', '123132133132', '132123321232', '13213212313', '111111', '112121', '/profile/upload/2023/10/24/xds_20231024171232A001.png', '12321', '1232131', NULL, '0', NULL, '2023-10-24 15:13:16', NULL, '2023-11-26 05:04:19');

