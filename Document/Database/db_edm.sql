/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2017/8/31 9:42:17                            */
/*==============================================================*/


drop table authmanagement;
drop sequence Sequence_3;
drop table T_User;
drop sequence Seq_User_ID;
drop table T_Role;
drop index index_permission;
drop table T_Permission;


create sequence Sequence_3
increment 1
minvalue 1
NO MAXVALUE
start 1;

create sequence Seq_User_ID
increment 1
minvalue 1
NO MAXVALUE
NO CYCLE
start 1
cache 10;


/*==============================================================*/
/* Table: authmanagement                                        */
/*==============================================================*/
create table authmanagement (
   id                   INT8                 not null default nextval('Sequence_3'),
   name                 VARCHAR(20)          null,
   product              VARCHAR(50)          null,
   serinumber           VARCHAR(100)         null,
   version              VARCHAR(20)          null,
   date                 TIMESTAMP            null,
   authorizationcode    VARCHAR(50)          null,
   servernumber         VARCHAR(50)          null,
   aclient             VARCHAR(50)          null,
   type                 VARCHAR(50)          null,
   status               INT2                 null,
   bclient_machinecode  TEXT                null,
   bauth_serilizenumber TEXT                 null,
   contractnumber       VARCHAR(100)         null,
   supervene_number     VARCHAR(50)          null,
   auth_timeout         VARCHAR(50)          null,
   constraint PK_AUTHMANAGEMENT primary key (id)
);

comment on table authmanagement is
'授权管理';

comment on column authmanagement.id is
'id';

comment on column authmanagement.name is
'用户名';

comment on column authmanagement.product is
'软件产品';

comment on column authmanagement.serinumber is
'序列号';

comment on column authmanagement.version is
'版本';

comment on column authmanagement.date is
'授权日期';

comment on column authmanagement.authorizationcode is
'授权码';

comment on column authmanagement.servernumber is
'服务编号';

comment on column authmanagement.a_client is
'A级客户';

comment on column authmanagement.type is
'规格';

comment on column authmanagement.status is
'状态';

comment on column authmanagement.b_client_machinecode is
'B级客户机器码';

comment on column authmanagement.b_auth_serilizenumber is
'B级客户授权序列号';
comment on column authmanagement.contractnumber is
'合同码';

comment on column authmanagement.supervene_number is
'并发数';

comment on column authmanagement.auth_timeout is
'授权期限';


/*==============================================================*/
/* Table: T_User                                                */
/*==============================================================*/
create table T_User (
   ID                   INT8                 not null default nextval('Seq_User_ID'),
   UserName             VARCHAR(128)         not null,
   NickName             VARCHAR(128)         null,
   Password             VARCHAR(128)         null,
   Status               INT8                 not null default 1,
   CreateTime           TIMESTAMP            not null default CURRENT_TIMESTAMP,
   UserGroups           VARCHAR(128)         null,
   Email                VARCHAR(128)         null,
   Phone                VARCHAR(128)         null,
   Type                 INT8                 not null default 0,
   UserRoles            VARCHAR(128)         null,
   UUID                 VARCHAR(128)         null,
   DomainEntryID        VARCHAR(128)         null,
   Domain               VARCHAR(128)         not null,
   LastLogin            TIMESTAMP            null,
   SessionStatus        VARCHAR(128)         not null default '0',
   Version              INT8                 not null default 0,
   Reserve              VARCHAR(2048)        null,
   ecenterid            VARCHAR(128)         null,
   constraint PK_T_USER primary key (ID)
);

comment on table T_User is
'注意：vServer的Admin用户不能插入此表，此表的Domain字段只为LOCAL或域名。';

comment on column T_User.ID is
'用户ID';

comment on column T_User.UserName is
'存储的必须是小写用户名';

comment on column T_User.NickName is
'用户昵称';

comment on column T_User.Password is
'用户密码';

comment on column T_User.Status is
'1:启用      0:禁用';

comment on column T_User.CreateTime is
'创建时间';

comment on column T_User.UserGroups is
'将用户的组ID以"|"分隔，如：2|4|7';

comment on column T_User.Email is
'Email';

comment on column T_User.Phone is
'电话';

comment on column T_User.Type is
'0:本地用户  1:域用户';

comment on column T_User.UserRoles is
'将角色ID以“|”分隔,如：1|3|6|8';

comment on column T_User.UUID is
'当用户来自vServer时此自动不能空';

comment on column T_User.DomainEntryID is
'当为域用户时，记录用户域标识';

comment on column T_User.Domain is
'Type为0时为LOCAL，Type为1时为域名';

comment on column T_User.LastLogin is
'最后一次登录';

comment on column T_User.SessionStatus is
'1:在线      0:离线';

comment on column T_User.Version is
'记录版本';

comment on column T_User.Reserve is
'预留';

comment on column T_User.ecenterid is
'ecenterid';

INSERT INTO t_user (username, nickname, password, status, UserRoles, createtime, type, domain,sessionstatus) 
VALUES ('admin', '系统管理员', '04d9f34c7e70653a1b86f7d6ca8fc325ddb5092f198cd86d3fcc1068c7dd12d4', 1, '1', LOCALTIMESTAMP(0), 0, 'LOCAL','1');

/*==============================================================*/
/* Table: T_Role                                                */
/*==============================================================*/
create table T_Role (
   ID                   INT8                 not null,
   Role_Name            VARCHAR(128)         not null,
   Role_Sign            VARCHAR(128)         not null,
   Discription          VARCHAR(2048)        not null,
   RolePermissions      VARCHAR(128)         null,
   Version              INT8                 not null default 0,
   Reserve              VARCHAR(2048)        null,
   constraint PK_T_ROLE primary key (ID)
);

comment on table T_Role is
'角色表';

comment on column T_Role.ID is
'角色ID';

comment on column T_Role.Role_Name is
'角色名称';

comment on column T_Role.Role_Sign is
'如：admin，角色标识，程序中判断使用。';

comment on column T_Role.Discription is
'角色描述';

comment on column T_Role.RolePermissions is
'将权限ID用"|"分隔，如：1|2|4|8';

comment on column T_Role.Version is
'记录版本';

comment on column T_Role.Reserve is
'预留';

INSERT INTO t_role (id, role_name, role_sign, RolePermissions, discription) 
VALUES (1, '超级管理员', 'admin', '1|2', '系统超级管理员，允许执行所有操作');
/*==============================================================*/
/* Table: T_Permission                                          */
/*==============================================================*/
create table T_Permission (
   ID                   INT8                 not null,
   Permission_Name      VARCHAR(128)         not null,
   Permission_Sign      VARCHAR(128)         not null,
   Discription          VARCHAR(2048)        not null,
   Version              INT8                 not null default 0,
   Reserve              VARCHAR(2048)        null,
   constraint PK_T_PERMISSION primary key (ID)
);

comment on table T_Permission is
'权限表';

comment on column T_Permission.ID is
'权限ID';

comment on column T_Permission.Permission_Name is
'权限名称';

comment on column T_Permission.Permission_Sign is
'如“User:Login”、"User:ResetPwd"程序中用来判断权限的标识。';

comment on column T_Permission.Discription is
'权限描述';

comment on column T_Permission.Version is
'记录版本';

comment on column T_Permission.Reserve is
'预留';

INSERT INTO t_permission (id, permission_name, permission_sign, discription)
VALUES(1, '登录管理端', 'user:admin_login', '允许用户登录WEB管理端');

INSERT INTO t_permission (id, permission_name, permission_sign, discription)
VALUES(2, '登录客户端', 'user:client_login', '允许用户从桌面客户端登陆');

/*==============================================================*/
/* Index: index_permission                                      */
/*==============================================================*/
create unique index index_permission on T_Permission (
   ID
);
