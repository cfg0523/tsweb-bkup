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
    menu_resource_type varchar(32) comment '菜单权限资源类别',
    menu_parent_id varchar(32) comment '父级菜单ID',
    menu_acl_pos int comment '菜单访问控制位',
    menu_create_by varchar(32) comment '创建人ID',
    menu_create_date datetime comment '创建时间',
    menu_update_by varchar(32) comment '修改人ID',
    menu_update_date datetime comment '修改时间',
    menu_remark varchar(256) comment '备注',
    primary key(menu_id),
    unique key(menu_resource_type, menu_name)
) comment '菜单资源表';
insert into sys_menu_mstr values ('M00', 'brand', 'TSWEB', '/', 'brand', null, 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M01', 'sys', '系统管理', '/sys', 'module', 'M00', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M02', 'hayden', 'Hayden', '', 'module', 'M00', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M03', 'qareport', 'QAReport', '/qareport', 'module', 'M00', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M04', 'eimi', 'EIMI', '/eimi', 'module', 'M02', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M05', 'custrpt', 'CustRpt', '/custrpt', 'module', 'M02', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M06', 'user', '用户管理', '/sys/user', 'sys', 'M01', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M07', 'role', '角色管理', '/sys/role', 'sys', 'M01', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M08', 'menu', '菜单管理', '/sys/menu', 'sys', 'M01', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M09', 'comp', '组件管理', '/sys/comp', 'sys', 'M01', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M10', 'daily', 'Daily', '/qareport/daily', 'qareport', 'M03', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M11', 'detail', 'Detail', '', 'qareport', 'M03', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M12', 'master', 'Master', '', 'qareport', 'M03', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M13', 'report', 'Report', '', 'qareport', 'M03', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M14', 'podetail', 'PO Detail', '/qareport/detail/podetail', 'qareport', 'M11', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M15', 'dftdetail', 'DFT Detail', '/qareport/detail/dftdetail', 'qareport', 'M11', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M16', 'aqldetail', 'AQL Detail', '/qareport/detail/aqldetail', 'qareport', 'M11', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M17', 'pkgdetail', 'PKG Detail', '/qareport/detail/pkgdetail', 'qareport', 'M11', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M18', 'techdetail', 'TECH Detail', '/qareport/detail/techdetail', 'qareport', 'M11', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M19', 'stamaster', 'Status Detail', '/qareport/master/stamaster', 'qareport', 'M12', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M20', 'aqlmaster', 'Aql Detail', '/qareport/master/aqlmaster', 'qareport', 'M12', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M21', 'genreport', 'Generate Report', '/qareport/report/generate', 'qareport', 'M13', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M22', 'forgen', 'For Gen Report', '/qareport/report/for', 'qareport', 'M13', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M23', 'tolm', 'TOLM', '/tolm', 'module', 'M02', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M24', 'shipdoc', 'ShipDoc', '/shipdoc', 'module', 'M02', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M25', 'bomcompare', 'BomCompare', '/bomcompare', 'module', 'M02', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M26', 'fantasy', 'Fantasy', '', 'module', 'M00', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M27', 'csm', 'CSM', '/csm', 'module', 'M26', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M28', 'pcaudit', 'PCAudit', '/pcaudit', 'module', 'M26', 1, '', null, '', null, '');

insert into sys_menu_mstr values ('M29', 'xfliu', 'XFLiu', '', 'module', 'M00', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M30', 'ehr', 'EHR', '/ehr', 'module', 'M29', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M31', 'pngen', 'PNGen', '/pngen', 'module', 'M29', 1, '', null, '', null, '');
insert into sys_menu_mstr values ('M32', 'mis3000', 'MIS3000', '/mis3000', 'module', 'M29', 1, '', null, '', null, '');

/**
 * sys_component_mstr
 * Resource: Component
 */
drop table if exists sys_component_mstr;
create table sys_component_mstr (
    component_id varchar(32) comment '组件资源ID',
    component_name varchar(32) not null comment '组件资源名',
    component_desc varchar(64) comment '组件资源功能描述',
    component_resource_type varchar(32) not null comment '组件权限资源类型',
    component_java_type varchar(64) comment '组件资源类名',
    component_create_by varchar(32) comment '创建人ID',
    component_create_date datetime comment '创建时间',
    component_update_by varchar(32) comment '修改人ID',
    component_update_date datetime comment '修改时间',
    component_remark varchar(256) comment '备注',
    primary key(component_id),
    unique key(component_resource_type, component_name)
) comment '组件资源表';

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
    operation_acl_pos int comment '方法访问控制位',
    operation_create_by varchar(32) comment '创建人ID',
    operation_create_date datetime comment '创建时间',
    operation_update_by varchar(32) comment '修改人ID',
    operation_update_date datetime comment '修改时间',
    operation_remark varchar(256) comment '备注',
    primary key(operation_id),
    unique key(operation_component_id, operation_acl_pos),
    unique key(operation_component_id, operation_name, operation_diff)
) comment '方法表';


/**
 * sys_acl_det;
 */
drop table if exists sys_acl_det;
create table sys_acl_det (
    acl_id varchar(32) comment '访问控制ID',
    acl_principal_type varchar(32) not null comment '访问控制AuthPrincipal的类型',
    acl_principal_name varchar(32) not null comment '访问控制AuthPrincipal的名称',
    acl_resource_type varchar(32) not null comment '访问控制AuthResource的类型',
    acl_resource_name varchar(32) not null comment '访问控制AuthResource的名称',
    acl_code int comment '访问控制码',
    acl_create_by varchar(32) comment '创建人ID',
    acl_create_date datetime comment '创建时间',
    acl_update_by varchar(32) comment '修改人ID',
    acl_update_date datetime comment '修改时间',
    acl_remark varchar(256) comment '备注',
    primary key(acl_id),
    unique key(acl_principal_name, acl_resource_name)
) comment '访问控制表';
insert into sys_acl_det values ('ACL1', 'role', 'programmer', 'menu', 'sys', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL2', 'role', 'programmer', 'menu', 'menu', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL3', 'role', 'programmer', 'menu', 'comp', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL4', 'role', 'manager', 'menu', 'sys', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL5', 'role', 'manager', 'menu', 'user', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL6', 'role', 'manager', 'menu', 'role', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL7', 'role', 'staff', 'menu', 'sys', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL8', 'role', 'staff', 'menu', 'user', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL9', 'role', 'staff', 'menu', 'role', 1, '', null, '', null, '');
insert into sys_acl_det values ('ACL10', 'user', 'giny', 'menu', 'menu', 1, '', null, '', null, '');
