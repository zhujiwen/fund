create database if not exists fund;
use fund;
create table if not exists company
(
    id   int auto_increment primary key comment '自增id',
    name varchar(100) comment '公司名称'
) comment '基金公司表';


create table fund_base_info
(
    id         int primary key comment '唯一id',
    fcode      int comment '基金code',
    short_name varchar(100) comment '资金名称'
) comment '基金基本信息表';


create table fund_detail_info
(
    id    bigint primary key comment '自增id',
    fcode int comment '基金code',
    fsrq  varchar(20) comment '净值日期',
    dwjz  varchar(20) comment '单位净值',
    ljjz  varchar(20) comment '累计净值',
    jzzzl varchar(20) comment '日增长率'
) comment '基金详细信息表';