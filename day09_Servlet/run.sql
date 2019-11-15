-- 生成序列,用于给定ID的值
create sequence ID
minvalue 1
maxvalue 99999999999999999999
start with 1
increment by 1
nocache;

-- 创建表
create table USER28
(
    ID       NUMBER       not null
        constraint TABLE_NAME_PK
            primary key,
    USERNAME VARCHAR2(32) not null,
    PASSWORD VARCHAR2(32) not null
)


