/**
 * sys_user
 */
drop table if exists sys_user;
create table sys_user (
    id varchar(32),
    user_name varchar(32) not null comment '用户英文名',
    user_pwd varchar(32) not null comment '密码',
    create_by varchar(32) comment '创建人ID',
    create_date datetime comment '创建时间',
    update_by varchar(32) comment '修改人ID',
    update_date datetime comment '修改时间',
    remark varchar(256) comment '备注',
    primary key(id),
    unique key(user_name)
) comment '用户表';
insert into sys_user values ('1', 'hayden', 'qiannianhu', '1', '2015-01-01 00:00:00', '1', '2015-01-01 00:00:00', 'test by hayden');

/**
 * sys_role
 */
drop table if exists sys_role;
create table sys_role (
    id varchar(32),
    role_name varchar(32) not null comment '角色名',
    create_by varchar(32) comment '创建人ID',
    create_date datetime comment '创建时间',
    update_by varchar(32) comment '修改人ID',
    update_date datetime comment '修改时间',
    remark varchar(256) comment '备注',
    primary key(id),
    unique key(role_name)
) comment '角色表';
insert into sys_role values ('1', 'administrator', '1', '2015-01-01 00:00:00', '1', '2015-01-01 00:00:00', 'test by hayden');

/**
 * sys_auth
 */
drop table if exists sys_auth;
create table sys_auth (
    id varchar(32),
    auth_name varchar(32) comment '权限名',
    auth_desc varchar(32) comment '权限描述',
    create_by varchar(32) comment '创建人ID',
    create_date datetime comment '创建时间',
    update_by varchar(32) comment '修改人ID',
    update_date datetime comment '修改时间',
    remark varchar(256) comment '备注',
    primary key(id),
    unique key(auth_name)
) comment '权限表';
insert into sys_auth values ('1', '*', '所有的权限', '1', '2015-01-01 00:00:00', '1', '2015-01-01 00:00:00', 'test by hayden');

/**
 * sys_user_role
 */
drop table if exists sys_user_role;
create table sys_user_role (
    id varchar(32),
    user_id varchar(32) comment '用户ID',
    role_id varchar(32) comment '角色ID',
    create_by varchar(32) comment '创建人ID',
    create_date datetime comment '创建时间',
    update_by varchar(32) comment '修改人ID',
    update_date datetime comment '修改时间',
    remark varchar(256) comment '备注',
    primary key(id),
    unique key(user_id, role_id)
) comment '用户角色表';
insert into sys_user_role values ('1', '1', '1', '1', '2015-01-01 00:00:00', '1', '2015-01-01 00:00:00', 'test by hayden');

/**
 * sys_role_auth
 */
drop table if exists sys_role_auth;
create table sys_role_auth (
    id varchar(32),
    role_id varchar(32) comment '角色ID',
    auth_id varchar(32) comment '角色ID',
    create_by varchar(32) comment '创建人ID',
    create_date datetime comment '创建时间',
    update_by varchar(32) comment '修改人ID',
    update_date datetime comment '修改时间',
    remark varchar(256) comment '备注',
    primary key(id),
    unique key(role_id, auth_id)
) comment '角色权限表';
insert into sys_role_auth values ('1', '1', '1', '1', '2015-01-01 00:00:00', '1', '2015-01-01 00:00:00', 'test by hayden');
