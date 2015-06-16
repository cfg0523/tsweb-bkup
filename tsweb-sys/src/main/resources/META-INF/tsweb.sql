/**
 * sys_user_mstr
 * Principal: User
 */
drop table if exists sys_user_mstr;
create table sys_user_mstr (
    user_id varchar(32),
    user_name varchar(32) not null comment '用户英文名',
    user_password varchar(32) not null comment '密码',
    user_create_by varchar(32) comment '创建人ID',
    user_create_date datetime comment '创建时间',
    user_update_by varchar(32) comment '修改人ID',
    user_update_date datetime comment '修改时间',
    user_remark varchar(256) comment '备注',
    primary key(user_id),
    unique key(user_name)
) comment '用户表';
insert into sys_user_mstr values ('U1', 'hayden', 'hayden', '', null, '', null, '');
insert into sys_user_mstr values ('U2', 'fantasy', 'fantasy', '', null, '', null, '');
insert into sys_user_mstr values ('U3', 'giny', 'giny', '', null, '', null, '');
insert into sys_user_mstr values ('U4', 'yilia', 'yilia', '', null, '', null, '');
insert into sys_user_mstr values ('U5', 'tracy', 'tracy', '', null, '', null, '');

/**
 * sys_role_mstr
 * Principal: Role
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
insert into sys_role_mstr values ('R1', 'programmer', '程序员', '', null, '', null, '');
insert into sys_role_mstr values ('R2', 'manager', '经理', '', null, '', null, '');
insert into sys_role_mstr values ('R3', 'staff', '职员', '', null, '', null, '');

/**
 * sys_userrole_det
 */
drop table if exists sys_userrole_det;
create table sys_userrole_det (
    userrole_id varchar(32) comment '用户角色ID',
    userrole_user_id varchar(32) not null comment '用户ID',
    userrole_role_id varchar(32) not null comment '角色ID',
    userrole_create_by varchar(32) comment '创建人ID',
    userrole_create_date datetime comment '创建时间',
    userrole_update_by varchar(32) comment '修改人ID',
    userrole_update_date datetime comment '修改时间',
    userrole_remark varchar(256) comment '备注',
    primary key(userrole_id),
    unique key(userrole_user_id, userrole_role_id)
) comment '用户角色表';
insert into sys_userrole_det values ('UR1', 'U1', 'R1', '', null, '', null, '');
insert into sys_userrole_det values ('UR2', 'U1', 'R3', '', null, '', null, '');
insert into sys_userrole_det values ('UR3', 'U2', 'R1', '', null, '', null, '');
insert into sys_userrole_det values ('UR4', 'U2', 'R3', '', null, '', null, '');
insert into sys_userrole_det values ('UR5', 'U3', 'R2', '', null, '', null, '');
insert into sys_userrole_det values ('UR6', 'U4', 'R3', '', null, '', null, '');
insert into sys_userrole_det values ('UR7', 'U5', 'R3', '', null, '', null, '');

/**
 * sys_menu_mstr
 * Resource: Menu
 */
drop table if exists sys_menu_mstr;
create table sys_menu_mstr (
    menu_id varchar(32) comment '菜单ID',
    menu_name varchar(32) not null comment '菜单资源名',
    menu_desc varchar(32) comment '菜单描述',
    menu_path varchar(32) comment '菜单路径',
    menu_type varchar(32) comment '菜单类别',
    menu_parent_id varchar(32) comment '父级菜单ID',
    menu_acl_bit int comment '菜单访问控制位',
    menu_create_by varchar(32) comment '创建人ID',
    menu_create_date datetime comment '创建时间',
    menu_update_by varchar(32) comment '修改人ID',
    menu_update_date datetime comment '修改时间',
    menu_remark varchar(256) comment '备注',
    primary key(menu_id),
    unique key(menu_name)
) comment '菜单资源表';
insert into sys_menu_mstr values ('M1', 'menu:sys', '系统管理', '', 'nav', '', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M2', 'menu:user', '用户管理', '/menu/user', 'nav', 'M1', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M3', 'menu:role', '角色管理', '/menu/role', 'nav', 'M1', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M4', 'menu:menu', '菜单管理', '/menu/menu', 'nav', 'M1', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M5', 'menu:component', '组件管理', '/menu/component', 'nav', 'M1', 1, '', null, '', null, '');

/**
 * sys_component_mstr
 * Resource: Component
 */
drop table if exists sys_component_mstr;
create table sys_component_mstr (
    component_id varchar(32) comment '组件资源ID',
    component_name varchar(32) not null comment '组件资源名',
    component_type varchar(32) not null comment '组件资源类型',
    component_desc varchar(64) comment '组件资源功能描述',
    component_java_type varchar(64) comment '组件资源类名',
    component_create_by varchar(32) comment '创建人ID',
    component_create_date datetime comment '创建时间',
    component_update_by varchar(32) comment '修改人ID',
    component_update_date datetime comment '修改时间',
    component_remark varchar(256) comment '备注',
    primary key(component_id),
    unique key(component_name)
) comment '组件资源表';
/*
insert into sys_component_mstr values ('C1', 'LoginController', 'controller', '登录控制器', 'LoginController', '', null, '', null, '');
*/

/**
 * sys_operation_det
 * Resource: Operation
 */
drop table if exists sys_operation_det;
create table sys_operation_det (
    operation_id varchar(32) comment '方法ID',
    operation_component_id varchar(32) not null comment '方法所属组件的ID',
    operation_name varchar(32) not null comment '方法名',
    operation_diff varchar(32) comment '同名方法区分字段',
    operation_desc varchar(64) comment '方法描述',
    operation_acl_bit int comment '方法访问控制码',
    operation_create_by varchar(32) comment '创建人ID',
    operation_create_date datetime comment '创建时间',
    operation_update_by varchar(32) comment '修改人ID',
    operation_update_date datetime comment '修改时间',
    operation_remark varchar(256) comment '备注',
    primary key(operation_id),
    unique key(operation_component_id, operation_acl_bit),
    unique key(operation_component_id, operation_name, operation_diff)
) comment '方法表';
/*
insert into sys_operation_det values ('O1', 'C1', 'login', '', '用户登录', 1, '', null, '', null, '');
*/


/**
 * sys_acl_det;
 */
drop table if exists sys_acl_det;
create table sys_acl_det (
    acl_id varchar(32) comment '访问控制ID',
    acl_principal_id varchar(32) not null comment '访问控制Principal的ID',
    acl_principal_type varchar(32) not null comment '访问控制Principal的类型',
    acl_resource_id varchar(32) not null comment '访问控制Resource的ID',
    acl_resource_type varchar(32) not null comment '访问控制Resource的类型',
    acl_code int comment '访问控制码',
    acl_create_by varchar(32) comment '创建人ID',
    acl_create_date datetime comment '创建时间',
    acl_update_by varchar(32) comment '修改人ID',
    acl_update_date datetime comment '修改时间',
    acl_remark varchar(256) comment '备注',
    primary key(acl_id),
    unique key(acl_principal_id, acl_principal_type, acl_resource_id, acl_resource_type)
) comment '访问控制表';
insert into sys_acl_det values ('ACL1', 'R1', 'Role', 'M1', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL2', 'R1', 'Role', 'M4', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL3', 'R1', 'Role', 'M5', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL4', 'R2', 'Role', 'M1', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL5', 'R2', 'Role', 'M2', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL6', 'R2', 'Role', 'M3', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL7', 'R3', 'Role', 'M1', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL8', 'R3', 'Role', 'M2', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL9', 'R3', 'Role', 'M3', 'Menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL10', 'U3', 'User', 'M4', 'Menu', 1, '', null, '', null, '');
