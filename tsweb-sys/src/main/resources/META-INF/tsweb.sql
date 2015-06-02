/**
 * sys_user_mstr
 */
drop table if exists sys_user_mstr;
create table sys_user_mstr (
    user_id varchar(32),
    user_name varchar(32) not null comment '用户英文名',
    user_pwd varchar(32) not null comment '密码',
    user_create_by varchar(32) comment '创建人ID',
    user_create_date datetime comment '创建时间',
    user_update_by varchar(32) comment '修改人ID',
    user_update_date datetime comment '修改时间',
    user_remark varchar(256) comment '备注',
    primary key(user_id),
    unique key(user_name)
) comment '用户表';
insert into sys_user_mstr values ('U1', 'admin', 'admin', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_mstr values ('U2', 'giny', 'giny', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_mstr values ('U3', 'syxie', 'syxie', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_mstr values ('U4', 'hayden', 'hayden', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_user_mstr values ('U5', 'yilia', 'yilia', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

/**
 * sys_role_mstr
 */
drop table if exists sys_role_mstr;
create table sys_role_mstr (
    role_id varchar(32),
    role_name varchar(32) not null comment '角色名',
    role_desc varchar(32) comment '角色描述',
    role_create_by varchar(32) comment '创建人ID',
    role_create_date datetime comment '创建时间',
    role_update_by varchar(32) comment '修改人ID',
    role_update_date datetime comment '修改时间',
    role_remark varchar(256) comment '备注',
    primary key(role_id),
    unique key(role_name)
) comment '角色表';
insert into sys_role_mstr values ('R1', 'superuser', '超级管理员', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role_mstr values ('R2', 'manager', '经理', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_role_mstr values ('R3', 'staff', '职员', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

/**
 * sys_auth_mstr
 */
drop table if exists sys_auth_mstr;
create table sys_auth_mstr (
    auth_id varchar(32),
    auth_name varchar(32) not null comment '权限名',
    auth_desc varchar(32) comment '权限描述',
    auth_create_by varchar(32) comment '创建人ID',
    auth_create_date datetime comment '创建时间',
    auth_update_by varchar(32) comment '修改人ID',
    auth_update_date datetime comment '修改时间',
    auth_remark varchar(256) comment '备注',
    primary key(auth_id),
    unique key(auth_name)
) comment '权限表';
insert into sys_auth_mstr values ('A1', '*:*', '所有的权限', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth_mstr values ('A2', 'user:*', '对用户操作有所有权限', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth_mstr values ('A3', 'user:view', '查看用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth_mstr values ('A4', 'user:add', '添加用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth_mstr values ('A5', 'user:update', '修改用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth_mstr values ('A6', 'user:delete', '删除用户', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_auth_mstr values ('A7', 'menu:*', '对菜单操作有所有权限', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

/**
 * sys_userrole_det
 */
drop table if exists sys_userrole_det;
create table sys_userrole_det (
    userrole_uid varchar(32) comment '用户ID',
    userrole_rid varchar(32) comment '角色ID',
    userrole_create_by varchar(32) comment '创建人ID',
    userrole_create_date datetime comment '创建时间',
    userrole_update_by varchar(32) comment '修改人ID',
    userrole_update_date datetime comment '修改时间',
    userrole_remark varchar(256) comment '备注',
    primary key(userrole_uid, userrole_rid)
) comment '用户角色表';
insert into sys_userrole_det values ('U1', 'R1', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_userrole_det values ('U2', 'R2', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_userrole_det values ('U3', 'R2', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_userrole_det values ('U4', 'R3', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_userrole_det values ('U5', 'R3', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');

/**
 * sys_roleauth_det
 */
drop table if exists sys_roleauth_det;
create table sys_roleauth_det (
    roleauth_rid varchar(32) comment '角色ID',
    roleauth_aid varchar(32) comment '权限ID',
    roleauth_create_by varchar(32) comment '创建人ID',
    roleauth_create_date datetime comment '创建时间',
    roleauth_update_by varchar(32) comment '修改人ID',
    roleauth_update_date datetime comment '修改时间',
    roleauth_remark varchar(256) comment '备注',
    primary key(roleauth_rid, roleauth_aid)
) comment '角色权限表';
insert into sys_roleauth_det values ('R1', 'A1', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_roleauth_det values ('R2', 'A2', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_roleauth_det values ('R3', 'A3', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_roleauth_det values ('R3', 'A4', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
insert into sys_roleauth_det values ('R3', 'A5', 'U1', '2015-01-01 00:00:00', 'U1', '2015-01-01 00:00:00', '');
