create database if not exists fund;
use fund;
create table if not exists company
(
    id   int auto_increment primary key comment '自增id',
    name varchar(100) comment '公司名称'
) comment '基金公司表';


CREATE TABLE fund_base_info
(
    id         bigint auto_increment NOT NULL COMMENT '唯一id',
    fcode      varchar(100) COMMENT '基金code',
    short_name varchar(100) COMMENT '资金名称',
    detail_data_date varchar(10) comment '基金明细数据最新时间',
    PRIMARY KEY (`id`)
) COMMENT '基金基本信息表';


create table fund_detail_info
(
    id    bigint auto_increment primary key comment '自增id',
    fcode int comment '基金code',
    fsrq  varchar(20) comment '净值日期',
    dwjz  varchar(20) comment '单位净值',
    ljjz  varchar(20) comment '累计净值',
    jzzzl varchar(20) comment '日增长率'
) comment '基金每日净值明细表';

create table sync_time
(
    util_time varchar(19) comment '爬取数据截止到某天'
) comment '爬取数据截止时间';

CREATE TABLE `collect`
(
    `id`        bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_name` varchar(30) DEFAULT NULL COMMENT '用户id',
    `fcode`     int         DEFAULT NULL COMMENT '基金code',
    PRIMARY KEY (`id`)
) comment '收藏表';

CREATE TABLE `purchase`
(
    `id`        bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_name` varchar(30) DEFAULT NULL COMMENT '用户id',
    `fcode`     int         DEFAULT NULL COMMENT '基金code',
    PRIMARY KEY (`id`)
) comment '购买表';

create table user
(
    user_id  varchar(20) comment '用户id',
    password varchar(30) comment '密码',
    primary key (user_id)
) comment '用户信息表';