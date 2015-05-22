/**
 * sys_usr_mstr
 */
drop table if exists sys_usr_mstr;
create table sys_usr_mstr (
    id varchar(32),
    usr_name varchar(32) not null comment '用户名',
    usr_pwd varchar(32) not null comment '密码',
    create_by varchar(32) comment '创建人ID',
    create_date datetime comment '创建时间',
    update_by varchar(32) comment '修改人ID',
    update_date datetime comment '修改时间',
    remark varchar(256) comment '备注',
    primary key(id),
    unique key(usr_name)
);
