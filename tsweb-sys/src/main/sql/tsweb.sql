/**
 * sys_usr_mstr
 */
drop table if exists sys_usr_mstr;
create table sys_usr_mstr (
    id varchar(32) primary key,
    usr_name varchar(32) not null,
    usr_pwd varchar(32) not null,
    create_by varchar(32),
    create_date datetime,
    update_by varchar(32),
    update_date datetime,
    remark varchar(256)
);
