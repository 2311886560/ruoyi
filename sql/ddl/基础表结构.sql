-- 用户信息表sys_user
drop table if exists sys_user;
create table sys_user
(
    user_id        bigint(20)  not null auto_increment comment '用户ID',
    dept_id        bigint(20)   default null comment '部门ID',
    retired_id     bigint(20)   default null comment '干休所ID',
    hospital_id    bigint(20)   default null comment '医院ID',
    user_name      varchar(30) not null comment '用户账号',
    password       varchar(100) default '' comment '密码',
    nick_name      varchar(30) not null comment '用户昵称',
    user_type      varchar(2)   default '21' comment '用户类型（00：系统用户，10：医务人员，11：医务数据管理人员，21：退休老干部）',
    status         char(1)      default '0' comment '帐号状态（0正常 1停用）',
    email          varchar(50)  default '' comment '用户邮箱',
    phonenumber    varchar(11)  default '' comment '手机号码',
    pressing_phone varchar(11)  default '' comment '紧急联系人电话',
    sex            char(1)      default '0' comment '用户性别（0男 1女 2未知）',
    id_card        varchar(50)  default NULL comment '身份证号码',
    age            varchar(10)  default '0' comment '年龄',
    medical_age    varchar(10)  default '0' comment '医龄',
    posts          varchar(50)  default null comment '职务',
    address        varchar(100) default '' comment '家庭住址',
    avatar         varchar(100) default '' comment '头像地址',
    del_flag       char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    login_ip       varchar(128) default '' comment '最后登录IP',
    login_date     datetime comment '最后登录时间',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(500) default null comment '备注',
    primary key (user_id)
) engine = innodb
  auto_increment = 100 comment = '用户信息表';

-- 干休所信息表retired
drop table if exists retired;
create table retired
(
    id          bigint(20) not null auto_increment comment '干休所ID',
    name        varchar(50)  default null comment '干休所名称',
    address     varchar(100) default null comment '地址',
    unit        varchar(100) default null comment '负责单位',
    phone       varchar(12)  default null comment '联系电话',
    head        varchar(30)  default null comment '负责人',
    remark      varchar(500) default null comment '备注',
    status      varchar(2)   default '1' COMMENT '状态：0=失效，1=有效',
    del_flag    varchar(2)   default '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (id)
) engine = innodb comment = '干休所信息表';

-- 医院信息表hospital
drop table if exists hospital;
create table hospital
(
    id          bigint(20) not null auto_increment comment '医院ID',
    name        varchar(50)  default null comment '医院名称',
    number      varchar(50)  default null comment '医院社会代码',
    address     varchar(100) default null comment '地址',
    phone       varchar(12)  default null comment '联系电话',
    remark      varchar(500) default null comment '备注',
    status      varchar(2)   default '1' COMMENT '状态：0=失效，1=有效',
    del_flag    varchar(2)   default '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (id)
) engine = innodb comment = '医院信息表';

-- 体检数据信息表examine_physical
drop table if exists examine_physical;
create table examine_physical
(
    id              bigint(20) not null auto_increment comment '体检数据ID',
    medical_user_id bigint(20)   default null comment '医务人员用户ID',
    retired_user_id bigint(20)   default null comment '老干部用户ID',
    title           varchar(100) default null comment '体检标题',
    content         varchar(100) default null comment '体检内容',
    examine_time    datetime comment '体检时间',
    remark          varchar(500) default null comment '备注',
    process_status  varchar(2)   default '0' COMMENT '审核状态：0=未审核，1=审核通过，2=审核不通过',
    status          varchar(2)   default '1' COMMENT '状态：0=失效，1=有效',
    del_flag        varchar(2)   default '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    primary key (id)
) engine = innodb comment = '体检数据信息表';

-- 体检数据明细表examine_physical
drop table if exists examine_physical_detail;
create table examine_physical_detail
(
    id              bigint(20) not null auto_increment comment '体检数据明细ID',
    examine_id      bigint(20)   default null comment '体检数据ID',
    item_id         varchar(100) default null comment '体检项ID',
    name            varchar(100) default null comment '体检项名称',
    value           varchar(100) default '0' comment '体检值',
    reference_value varchar(100) default '0' comment '参考值',
    examine_time    datetime comment '体检时间',
    remark          varchar(500) default null comment '备注',
    status          varchar(2)   default '1' COMMENT '状态：0=失效，1=有效',
    del_flag        varchar(2)   default '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    primary key (id)
) engine = innodb comment = '体检数据明细表';

-- 体检项表examine_item
drop table if exists examine_item;
create table examine_item
(
    id              bigint(20) not null auto_increment comment '体检项ID',
    name            varchar(100) default null comment '体检项名称',
    reference_value varchar(100) default '0' comment '参考值',
    sex_status      varchar(2)   default '2' COMMENT '性别限制：0=男，1=女，2=不限制',
    default_status  varchar(2)   default '1' COMMENT '是否为默认：0=默认，1=不默认',
    show_user       varchar(2)   default '1' COMMENT '是否显示在个人中心：0=显示，1=不显示',
    remark          varchar(500) default null comment '备注',
    status          varchar(2)   default '1' COMMENT '状态：0=失效，1=有效',
    del_flag        varchar(2)   default '0' COMMENT '删除状态：0=未删除，1=已删除',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    primary key (id)
) engine = innodb comment = '体检项表';
