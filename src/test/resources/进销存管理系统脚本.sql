/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020-05-21 14:15:09                          */
/*==============================================================*/


DROP TABLE IF EXISTS BUSINESS_COMMODITY_PURCHASE;

DROP TABLE IF EXISTS BUSINESS_COMMODITY_SALE;

DROP TABLE IF EXISTS BUSINESS_COMMODITY_STOCK;

DROP TABLE IF EXISTS PUB_CLIENT_INFO;

DROP TABLE IF EXISTS PUB_COMMODITY_INFO;

DROP TABLE IF EXISTS PUB_COMMODITY_SPEC;

DROP TABLE IF EXISTS PUB_COMMODITY_TYPE;

DROP TABLE IF EXISTS PUB_DEPARTMENT;

DROP TABLE IF EXISTS PUB_SUPPLIER_INFO;

DROP TABLE IF EXISTS PUB_UNIT;

DROP TABLE IF EXISTS PUB_USERINFO;

DROP TABLE IF EXISTS PUB_USER_POWER;

DROP TABLE IF EXISTS PUB_USER_ROLE;

/*==============================================================*/
/* Table: BUSINESS_COMMODITY_PURCHASE                           */
/*==============================================================*/
CREATE TABLE BUSINESS_COMMODITY_PURCHASE
(
   ID                   VARCHAR(30) NOT NULL COMMENT 'ID',
   COMMODITY_CODE       VARCHAR(30) COMMENT '商品编码',
   CODE                 VARCHAR(30) COMMENT '供应商编码',
   PURCHASING_COST      DECIMAL(10,2) COMMENT '进货成本',
   PURCHASE_PRICE       DECIMAL(5,2) COMMENT '进货价格',
   SELLING_PRICE        DECIMAL(5,2) COMMENT '销售价格',
   PURCHASE_NUMBER      INT COMMENT '进货数量',
   PURCHASE_DATE        DATE COMMENT '进货日期',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (ID)
);

ALTER TABLE BUSINESS_COMMODITY_PURCHASE COMMENT '商品进货表';

/*==============================================================*/
/* Table: BUSINESS_COMMODITY_SALE                               */
/*==============================================================*/
CREATE TABLE BUSINESS_COMMODITY_SALE
(
   ID                   VARCHAR(30) NOT NULL COMMENT 'ID',
   COMMODITY_CODE       VARCHAR(30) COMMENT '商品编码',
   COMMODITY_NAME       VARCHAR(100) COMMENT '商品名称',
   SALE_NUMBER          INT COMMENT '销售数量',
   SALE_PRICE           DECIMAL(5,2) COMMENT '销售价格',
   CLIENT_CODE          VARCHAR(30) COMMENT '客户编码',
   SALE_PERSSON         VARCHAR(10) COMMENT '销售人员',
   SALE_DATE            DATE COMMENT '销售日期',
   REMARKS              TEXT COMMENT '备注',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (ID)
);

ALTER TABLE BUSINESS_COMMODITY_SALE COMMENT '商品销售表';

/*==============================================================*/
/* Table: BUSINESS_COMMODITY_STOCK                              */
/*==============================================================*/
CREATE TABLE BUSINESS_COMMODITY_STOCK
(
   ID                   VARCHAR(30) NOT NULL COMMENT 'ID',
   COMMODITY_CODE       VARCHAR(30) COMMENT '商品编码',
   LARGE_UNIT           VARCHAR(10) COMMENT '大单位',
   SMALL_UNIT           VARCHAR(10) COMMENT '小单位',
   SPEC_CODE            VARCHAR(30) COMMENT '商品规格',
   TOTAL_PRICE          DECIMAL(10,2) COMMENT '总价',
   INVENTORY            INT COMMENT '库存量',
   PRICE                DECIMAL(5,2) COMMENT '单价',
   MINIMUM_INVENTORY    INT COMMENT '最低库存量',
   PRIMARY KEY (ID)
);

ALTER TABLE BUSINESS_COMMODITY_STOCK COMMENT '商品库存表';

/*==============================================================*/
/* Table: PUB_CLIENT_INFO                                       */
/*==============================================================*/
CREATE TABLE PUB_CLIENT_INFO
(
   CODE                 VARCHAR(30) NOT NULL COMMENT '客户编码',
   NAME                 VARCHAR(100) COMMENT '客户名称',
   SPELL                VARCHAR(100) COMMENT '拼音简码',
   PERSON               VARCHAR(30) COMMENT '负责人',
   PHONE                VARCHAR(20) COMMENT '联系方式',
   EMAIL                VARCHAR(100) COMMENT '电子邮件',
   REMARKS              TEXT COMMENT '备注',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (CODE)
);

ALTER TABLE PUB_CLIENT_INFO COMMENT '客户信息表';

/*==============================================================*/
/* Table: PUB_COMMODITY_INFO                                    */
/*==============================================================*/
create table pub_commodity_info
(
    COMMODITY_CODE  varchar(30)      not null comment '商品编码'
        primary key,
    COMMODITY_NAME  varchar(100)     null comment '商品名称',
    COMMODITY_SPELL varchar(50)      null comment '拼音简码',
    SPEC_CODE       varchar(30)      not null comment '规格编码',
    TYPE_CODE       varchar(10)      not null comment '类型编码',
    UNIT_CODE       varchar(30)      null comment '计量单位',
    SUPPLIER_CODE   varchar(10)      not null comment '供应商',
    REMARKS         text             null comment '备注',
    STATUS          int(1) default 0 not null comment '状态',
    constraint FK_COMMODITY_SPEC
        foreign key (SPEC_CODE) references pub_commodity_spec (SPEC_CODE),
    constraint FK_COMMODITY_SUPPLIER
        foreign key (SUPPLIER_CODE) references pub_supplier_info (CODE),
    constraint FK_COMMODITY_TYPE
        foreign key (TYPE_CODE) references pub_commodity_type (TYPE_CODE),
    constraint FK_COMMODITY_UNIT
        foreign key (UNIT_CODE) references pub_unit (UNIT_CODE)
)
    comment '商品信息表';

/*==============================================================*/
/* Table: PUB_COMMODITY_SPEC                                    */
/*==============================================================*/
CREATE TABLE PUB_COMMODITY_SPEC
(
   SPEC_CODE            VARCHAR(30) NOT NULL COMMENT '规格编码',
   SPEC_NAME            VARCHAR(100) COMMENT '规格名称',
   SPEC_SPELL           VARCHAR(100) COMMENT '拼音简码',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (SPEC_CODE)
);

ALTER TABLE PUB_COMMODITY_SPEC COMMENT '商品规格表';

/*==============================================================*/
/* Table: PUB_COMMODITY_TYPE                                    */
/*==============================================================*/
CREATE TABLE PUB_COMMODITY_TYPE
(
   TYPE_CODE            VARCHAR(10) NOT NULL COMMENT '类型编码',
   TYPE_NAME            VARCHAR(30) COMMENT '类型名称',
   SPELL                VARCHAR(30) COMMENT '拼音简码',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (TYPE_CODE)
);

ALTER TABLE PUB_COMMODITY_TYPE COMMENT '商品类型表';

/*==============================================================*/
/* Table: PUB_DEPARTMENT                                        */
/*==============================================================*/
CREATE TABLE PUB_DEPARTMENT
(
   DEPART_CODE          VARCHAR(10) NOT NULL COMMENT '部门编码',
   DEPART_NAME          VARCHAR(30) COMMENT '部门名称',
   DEPART_SPELL         VARCHAR(100) COMMENT '拼音简码',
   REMARKS              TEXT COMMENT '简介',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (DEPART_CODE)
);

ALTER TABLE PUB_DEPARTMENT COMMENT '部门信息表';

/*==============================================================*/
/* Table: PUB_SUPPLIER_INFO                                     */
/*==============================================================*/
CREATE TABLE PUB_SUPPLIER_INFO
(
   CODE                 VARCHAR(30) NOT NULL COMMENT '供应商编码',
   NAME                 VARCHAR(30) COMMENT '供应商名称',
   SPELL                VARCHAR(30) COMMENT '拼音简码',
   ADDERS               VARCHAR(200) COMMENT '地址',
   PHONE                VARCHAR(20) COMMENT '联系方式',
   EMAIL                VARCHAR(200) COMMENT '电子邮件',
   REMARKS              TEXT COMMENT '备注',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (CODE)
);

ALTER TABLE PUB_SUPPLIER_INFO COMMENT '供应商信息表';

/*==============================================================*/
/* Table: PUB_UNIT                                              */
/*==============================================================*/
CREATE TABLE PUB_UNIT
(
   UNIT_CODE            VARCHAR(30) NOT NULL COMMENT '单位编码',
   UNIT_NAME            VARCHAR(30) COMMENT '单位名称',
   UNIT_SPELL           VARCHAR(30) COMMENT '拼音简码',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (UNIT_CODE)
);

ALTER TABLE PUB_UNIT COMMENT '计量单位表';

/*==============================================================*/
/* Table: PUB_USERINFO                                          */
/*==============================================================*/
CREATE TABLE PUB_USERINFO
(
   USER_CODE            VARCHAR(10) NOT NULL COMMENT '用户编码',
   DEPART_CODE          VARCHAR(10) COMMENT '部门编码',
   ROLE_COED            VARCHAR(10) COMMENT '角色编码',
   USER_NAME            VARCHAR(30) COMMENT '用户名称',
   USER_SPELL           VARCHAR(30) COMMENT '拼音简码',
   PASSWORD             VARCHAR(30) COMMENT '密码',
   STATUS               INTEGER NOT NULL COMMENT '状态',
   PRIMARY KEY (USER_CODE)
);

ALTER TABLE PUB_USERINFO COMMENT '用户信息表';

/*==============================================================*/
/* Table: PUB_USER_POWER                                        */
/*==============================================================*/
CREATE TABLE PUB_USER_POWER
(
   POWER_CODE           VARCHAR(10) NOT NULL COMMENT '权限编码',
   USER_CODE            VARCHAR(10) COMMENT '用户编码',
   ROLE_CODE            VARCHAR(10) COMMENT '角色编码',
   POWER_NAME           VARCHAR(30) COMMENT '权限名称',
   POWER_SPELL          VARCHAR(30) COMMENT '拼音简码',
   PRIMARY KEY (POWER_CODE)
);

ALTER TABLE PUB_USER_POWER COMMENT '用户权限表';

/*==============================================================*/
/* Table: PUB_USER_ROLE                                         */
/*==============================================================*/
CREATE TABLE PUB_USER_ROLE
(
   ROLE_COED            VARCHAR(10) NOT NULL COMMENT '角色编码',
   DEPART_CODE          VARCHAR(10) COMMENT '部门编码',
   ROLE_NAME            VARCHAR(30) COMMENT '角色名称',
   ROLE_SPELL           VARCHAR(30) COMMENT '拼音简码',
   STATUS               INT NOT NULL COMMENT '状态',
   PRIMARY KEY (ROLE_COED)
);

ALTER TABLE PUB_USER_ROLE COMMENT '用户角色表';

ALTER TABLE BUSINESS_COMMODITY_PURCHASE ADD CONSTRAINT FK_PURCHASE_COMMODITY FOREIGN KEY (COMMODITY_CODE)
      REFERENCES PUB_COMMODITY_INFO (COMMODITY_CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BUSINESS_COMMODITY_PURCHASE ADD CONSTRAINT FK_PURCHASE_SUPPLIER FOREIGN KEY (CODE)
      REFERENCES PUB_SUPPLIER_INFO (CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BUSINESS_COMMODITY_SALE ADD CONSTRAINT FK_CLIENT_COMMODITY_SALE FOREIGN KEY (CLIENT_CODE)
      REFERENCES PUB_CLIENT_INFO (CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BUSINESS_COMMODITY_SALE ADD CONSTRAINT FK_COMMODITY_SALE_CODE FOREIGN KEY (COMMODITY_CODE)
      REFERENCES PUB_COMMODITY_INFO (COMMODITY_CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BUSINESS_COMMODITY_STOCK ADD CONSTRAINT FK_COMMODITY_STOCK_CODE FOREIGN KEY (COMMODITY_CODE)
      REFERENCES PUB_COMMODITY_INFO (COMMODITY_CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PUB_USERINFO ADD CONSTRAINT FK_USERINFO_DEPART_CODE FOREIGN KEY (DEPART_CODE)
      REFERENCES PUB_DEPARTMENT (DEPART_CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PUB_USERINFO ADD CONSTRAINT FK_USER_ROLE_CODE FOREIGN KEY (ROLE_COED)
      REFERENCES PUB_USER_ROLE (ROLE_COED) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PUB_USER_POWER ADD CONSTRAINT FK_USER_RIGTHS_CODE FOREIGN KEY (USER_CODE)
      REFERENCES PUB_USERINFO (USER_CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PUB_USER_POWER ADD CONSTRAINT FK_USER_RIGTHS_ROLE_CODE FOREIGN KEY (ROLE_CODE)
      REFERENCES PUB_USER_ROLE (ROLE_COED) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PUB_USER_ROLE ADD CONSTRAINT FK_USER_ROLE_DEPART_CODE FOREIGN KEY (DEPART_CODE)
      REFERENCES PUB_DEPARTMENT (DEPART_CODE) ON DELETE RESTRICT ON UPDATE RESTRICT;

