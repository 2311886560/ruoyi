DROP TABLE IF EXISTS `examine_physical_auth_log`;
create table examine_physical_auth_log
(
    id                BIGINT(20) not null auto_increment primary key comment 'ID',
    examine_id        BIGINT(20)       DEFAULT NULL COMMENT '体检数据ID',
    auth_user         VARCHAR(64) comment '审核人',
    auth_user_id      BIGINT(20) comment '审核人ID',
    auth_status       VARCHAR(2) comment '审核状态 0=审核通过，1=审核不通过',
    reason            varchar(512) DEFAULT NULL COMMENT '审核原因',
    del_flag          VARCHAR(1)   DEFAULT '0' comment '删除标志',
    create_by         VARCHAR(64) comment '创建人',
    create_time       DATETIME comment '创建时间',
    update_by         VARCHAR(64) comment '更新人',
    update_time       DATETIME comment '更新日期',
    remark            VARCHAR(500) comment '备注'
) comment '体检数据审核记录表';