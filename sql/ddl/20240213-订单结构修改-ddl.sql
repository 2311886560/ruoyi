ALTER TABLE goods_order
    ADD COLUMN `produce_status` varchar(2) DEFAULT '0' COMMENT '生产状态：0=未开始,1=加工,2=组装,3=质检,4=包装,5=生产完成';
ALTER TABLE goods_order
    ADD COLUMN `delivery_time` datetime DEFAULT NULL COMMENT '交货时间';
ALTER TABLE goods_order
    ADD COLUMN `delivery_address` varchar(100) DEFAULT NULL COMMENT '交货地址';
ALTER TABLE goods_order
    ADD COLUMN `contact_phone` varchar(100) DEFAULT NULL COMMENT '联系方式';




