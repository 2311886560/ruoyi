
ALTER TABLE goods_info
    ADD COLUMN `goods_picture` varchar(256) DEFAULT null COMMENT '商品图片';

ALTER TABLE goods_order
    ADD COLUMN `order_invoice` varchar(256) DEFAULT null COMMENT '订单发票';
ALTER TABLE goods_order
    ADD COLUMN `payment_voucher` varchar(256) DEFAULT null COMMENT '付款凭证';




