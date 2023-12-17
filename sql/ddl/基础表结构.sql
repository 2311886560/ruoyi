-- 1、干休所信息表retired
drop table if exists retired;
create table retired
(
    r_id        bigint(20) not null auto_increment comment '干休所ID',
    r_name      varchar(50)  default null comment '干休所名称',
    r_address   varchar(100) default null comment '地址',
    r_unit      varchar(100) default null comment '负责单位',
    r_phone     varchar(12)  default null comment '联系电话',
    r_head      varchar(30)  default null comment '负责人',
    remark      varchar(500) default null comment '备注',
    status      varchar(2)   DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    del_flag    varchar(2)   DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (r_id)
) engine = innodb comment = '干休所信息表';

-- 2、医院信息表hospital
drop table if exists hospital;
create table hospital
(
    h_id        bigint(20) not null auto_increment comment '医院ID',
    h_name      varchar(50)  default null comment '医院名称',
    h_number      varchar(50)  default null comment '医院社会代码',
    h_address   varchar(100) default null comment '地址',
    h_phone     varchar(12)  default null comment '联系电话',
    remark      varchar(500) default null comment '备注',
    status      varchar(2)   DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    del_flag    varchar(2)   DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (h_id)
) engine = innodb comment = '医院信息表';

-- 3、体检数据信息表physical_info
drop table if exists physical_info;
create table physical_info
(
    id        bigint(20) not null auto_increment comment '体检数据ID',
    h_name      varchar(50)  default null comment '医院名称',
    h_number      varchar(50)  default null comment '医院社会代码',
    h_address   varchar(100) default null comment '地址',
    h_phone     varchar(12)  default null comment '联系电话',
    remark      varchar(500) default null comment '备注',
    status      varchar(2)   DEFAULT NULL COMMENT '状态：0=失效，1=有效',
    del_flag    varchar(2)   DEFAULT '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (id)
) engine = innodb comment = '医院信息表';
