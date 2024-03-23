ALTER TABLE examine_item
    ADD COLUMN `auto_status` varchar(2) DEFAULT '1' COMMENT '是否为自动检验：0=自动，1=不自动';
ALTER TABLE examine_item
    ADD COLUMN `max_auto_value` decimal(10, 2) DEFAULT NULL COMMENT '最高自动检验值';
ALTER TABLE examine_item
    ADD COLUMN `min_auto_value` decimal(10, 2) DEFAULT NULL COMMENT '最低自动检验值';

ALTER TABLE examine_physical_detail
    ADD COLUMN `auto_status` varchar(2) DEFAULT '1' COMMENT '是否为自动检验：0=自动，1=不自动';
ALTER TABLE examine_physical_detail
    ADD COLUMN `max_auto_value` decimal(10, 2) DEFAULT NULL COMMENT '最高自动检验值';
ALTER TABLE examine_physical_detail
    ADD COLUMN `min_auto_value` decimal(10, 2) DEFAULT NULL COMMENT '最低自动检验值';
ALTER TABLE examine_physical_detail
    ADD COLUMN `detection` varchar(100) DEFAULT NULL COMMENT '检测';

