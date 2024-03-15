ALTER TABLE goods_info
    ADD COLUMN `max_inventory` decimal(10, 2) DEFAULT NULL COMMENT '最高库存量';
ALTER TABLE goods_info
    ADD COLUMN `min_inventory` decimal(10, 2) DEFAULT NULL COMMENT '最低库存量';
