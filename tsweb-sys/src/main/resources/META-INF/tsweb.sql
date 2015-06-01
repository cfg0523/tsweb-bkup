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
insert into sys_user values ('U1', 'admin', 'admin', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user values ('U2', 'giny', 'giny', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user values ('U3', 'syxie', 'syxie', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user values ('U4', 'hayden', 'hayden', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user values ('U5', 'yilia', 'yilia', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

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
insert into sys_role values ('R1', 'superuser', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role values ('R2', 'manager', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role values ('R3', 'staff', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

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
insert into sys_auth values ('A1', '*:*', '所有的权限', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth values ('A2', 'user:*', '对用户操作有所有权限', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth values ('A3', 'user:view', '查看用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth values ('A4', 'user:add', '添加用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth values ('A5', 'user:update', '修改用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth values ('A6', 'user:delete', '删除用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth values ('A7', 'menu:*', '对菜单操作有所有权限', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

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
insert into sys_user_role values ('UR1', 'U1', 'R1', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_role values ('UR2', 'U2', 'R2', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_role values ('UR3', 'U3', 'R2', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_role values ('UR4', 'U4', 'R3', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_role values ('UR5', 'U5', 'R3', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

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
insert into sys_role_auth values ('RA1', 'R1', 'A1', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role_auth values ('RA2', 'R2', 'A2', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role_auth values ('RA3', 'R3', 'A3', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role_auth values ('RA4', 'R3', 'A4', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role_auth values ('RA5', 'R3', 'A5', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
