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
   COMMODITY_CODE       VARCHAR(30) COMMENT '��Ʒ����',
   CODE                 VARCHAR(30) COMMENT '��Ӧ�̱���',
   PURCHASING_COST      DECIMAL(10,2) COMMENT '�����ɱ�',
   PURCHASE_PRICE       DECIMAL(5,2) COMMENT '�����۸�',
   SELLING_PRICE        DECIMAL(5,2) COMMENT '���ۼ۸�',
   PURCHASE_NUMBER      INT COMMENT '��������',
   PURCHASE_DATE        DATE COMMENT '��������',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (ID)
);

ALTER TABLE BUSINESS_COMMODITY_PURCHASE COMMENT '��Ʒ������';

/*==============================================================*/
/* Table: BUSINESS_COMMODITY_SALE                               */
/*==============================================================*/
CREATE TABLE BUSINESS_COMMODITY_SALE
(
   ID                   VARCHAR(30) NOT NULL COMMENT 'ID',
   COMMODITY_CODE       VARCHAR(30) COMMENT '��Ʒ����',
   COMMODITY_NAME       VARCHAR(100) COMMENT '��Ʒ����',
   SALE_NUMBER          INT COMMENT '��������',
   SALE_PRICE           DECIMAL(5,2) COMMENT '���ۼ۸�',
   CLIENT_CODE          VARCHAR(30) COMMENT '�ͻ�����',
   SALE_PERSSON         VARCHAR(10) COMMENT '������Ա',
   SALE_DATE            DATE COMMENT '��������',
   REMARKS              TEXT COMMENT '��ע',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (ID)
);

ALTER TABLE BUSINESS_COMMODITY_SALE COMMENT '��Ʒ���۱�';

/*==============================================================*/
/* Table: BUSINESS_COMMODITY_STOCK                              */
/*==============================================================*/
CREATE TABLE BUSINESS_COMMODITY_STOCK
(
   ID                   VARCHAR(30) NOT NULL COMMENT 'ID',
   COMMODITY_CODE       VARCHAR(30) COMMENT '��Ʒ����',
   LARGE_UNIT           VARCHAR(10) COMMENT '��λ',
   SMALL_UNIT           VARCHAR(10) COMMENT 'С��λ',
   SPEC_CODE            VARCHAR(30) COMMENT '��Ʒ���',
   TOTAL_PRICE          DECIMAL(10,2) COMMENT '�ܼ�',
   INVENTORY            INT COMMENT '�����',
   PRICE                DECIMAL(5,2) COMMENT '����',
   MINIMUM_INVENTORY    INT COMMENT '��Ϳ����',
   PRIMARY KEY (ID)
);

ALTER TABLE BUSINESS_COMMODITY_STOCK COMMENT '��Ʒ����';

/*==============================================================*/
/* Table: PUB_CLIENT_INFO                                       */
/*==============================================================*/
CREATE TABLE PUB_CLIENT_INFO
(
   CODE                 VARCHAR(30) NOT NULL COMMENT '�ͻ�����',
   NAME                 VARCHAR(100) COMMENT '�ͻ�����',
   SPELL                VARCHAR(100) COMMENT 'ƴ������',
   PERSON               VARCHAR(30) COMMENT '������',
   PHONE                VARCHAR(20) COMMENT '��ϵ��ʽ',
   EMAIL                VARCHAR(100) COMMENT '�����ʼ�',
   REMARKS              TEXT COMMENT '��ע',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (CODE)
);

ALTER TABLE PUB_CLIENT_INFO COMMENT '�ͻ���Ϣ��';

/*==============================================================*/
/* Table: PUB_COMMODITY_INFO                                    */
/*==============================================================*/
create table pub_commodity_info
(
    COMMODITY_CODE  varchar(30)      not null comment '��Ʒ����'
        primary key,
    COMMODITY_NAME  varchar(100)     null comment '��Ʒ����',
    COMMODITY_SPELL varchar(50)      null comment 'ƴ������',
    SPEC_CODE       varchar(30)      not null comment '������',
    TYPE_CODE       varchar(10)      not null comment '���ͱ���',
    UNIT_CODE       varchar(30)      null comment '������λ',
    SUPPLIER_CODE   varchar(10)      not null comment '��Ӧ��',
    REMARKS         text             null comment '��ע',
    STATUS          int(1) default 0 not null comment '״̬',
    constraint FK_COMMODITY_SPEC
        foreign key (SPEC_CODE) references pub_commodity_spec (SPEC_CODE),
    constraint FK_COMMODITY_SUPPLIER
        foreign key (SUPPLIER_CODE) references pub_supplier_info (CODE),
    constraint FK_COMMODITY_TYPE
        foreign key (TYPE_CODE) references pub_commodity_type (TYPE_CODE),
    constraint FK_COMMODITY_UNIT
        foreign key (UNIT_CODE) references pub_unit (UNIT_CODE)
)
    comment '��Ʒ��Ϣ��';

/*==============================================================*/
/* Table: PUB_COMMODITY_SPEC                                    */
/*==============================================================*/
CREATE TABLE PUB_COMMODITY_SPEC
(
   SPEC_CODE            VARCHAR(30) NOT NULL COMMENT '������',
   SPEC_NAME            VARCHAR(100) COMMENT '�������',
   SPEC_SPELL           VARCHAR(100) COMMENT 'ƴ������',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (SPEC_CODE)
);

ALTER TABLE PUB_COMMODITY_SPEC COMMENT '��Ʒ����';

/*==============================================================*/
/* Table: PUB_COMMODITY_TYPE                                    */
/*==============================================================*/
CREATE TABLE PUB_COMMODITY_TYPE
(
   TYPE_CODE            VARCHAR(10) NOT NULL COMMENT '���ͱ���',
   TYPE_NAME            VARCHAR(30) COMMENT '��������',
   SPELL                VARCHAR(30) COMMENT 'ƴ������',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (TYPE_CODE)
);

ALTER TABLE PUB_COMMODITY_TYPE COMMENT '��Ʒ���ͱ�';

/*==============================================================*/
/* Table: PUB_DEPARTMENT                                        */
/*==============================================================*/
CREATE TABLE PUB_DEPARTMENT
(
   DEPART_CODE          VARCHAR(10) NOT NULL COMMENT '���ű���',
   DEPART_NAME          VARCHAR(30) COMMENT '��������',
   DEPART_SPELL         VARCHAR(100) COMMENT 'ƴ������',
   REMARKS              TEXT COMMENT '���',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (DEPART_CODE)
);

ALTER TABLE PUB_DEPARTMENT COMMENT '������Ϣ��';

/*==============================================================*/
/* Table: PUB_SUPPLIER_INFO                                     */
/*==============================================================*/
CREATE TABLE PUB_SUPPLIER_INFO
(
   CODE                 VARCHAR(30) NOT NULL COMMENT '��Ӧ�̱���',
   NAME                 VARCHAR(30) COMMENT '��Ӧ������',
   SPELL                VARCHAR(30) COMMENT 'ƴ������',
   ADDERS               VARCHAR(200) COMMENT '��ַ',
   PHONE                VARCHAR(20) COMMENT '��ϵ��ʽ',
   EMAIL                VARCHAR(200) COMMENT '�����ʼ�',
   REMARKS              TEXT COMMENT '��ע',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (CODE)
);

ALTER TABLE PUB_SUPPLIER_INFO COMMENT '��Ӧ����Ϣ��';

/*==============================================================*/
/* Table: PUB_UNIT                                              */
/*==============================================================*/
CREATE TABLE PUB_UNIT
(
   UNIT_CODE            VARCHAR(30) NOT NULL COMMENT '��λ����',
   UNIT_NAME            VARCHAR(30) COMMENT '��λ����',
   UNIT_SPELL           VARCHAR(30) COMMENT 'ƴ������',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (UNIT_CODE)
);

ALTER TABLE PUB_UNIT COMMENT '������λ��';

/*==============================================================*/
/* Table: PUB_USERINFO                                          */
/*==============================================================*/
CREATE TABLE PUB_USERINFO
(
   USER_CODE            VARCHAR(10) NOT NULL COMMENT '�û�����',
   DEPART_CODE          VARCHAR(10) COMMENT '���ű���',
   ROLE_COED            VARCHAR(10) COMMENT '��ɫ����',
   USER_NAME            VARCHAR(30) COMMENT '�û�����',
   USER_SPELL           VARCHAR(30) COMMENT 'ƴ������',
   PASSWORD             VARCHAR(30) COMMENT '����',
   STATUS               INTEGER NOT NULL COMMENT '״̬',
   PRIMARY KEY (USER_CODE)
);

ALTER TABLE PUB_USERINFO COMMENT '�û���Ϣ��';

/*==============================================================*/
/* Table: PUB_USER_POWER                                        */
/*==============================================================*/
CREATE TABLE PUB_USER_POWER
(
   POWER_CODE           VARCHAR(10) NOT NULL COMMENT 'Ȩ�ޱ���',
   USER_CODE            VARCHAR(10) COMMENT '�û�����',
   ROLE_CODE            VARCHAR(10) COMMENT '��ɫ����',
   POWER_NAME           VARCHAR(30) COMMENT 'Ȩ������',
   POWER_SPELL          VARCHAR(30) COMMENT 'ƴ������',
   PRIMARY KEY (POWER_CODE)
);

ALTER TABLE PUB_USER_POWER COMMENT '�û�Ȩ�ޱ�';

/*==============================================================*/
/* Table: PUB_USER_ROLE                                         */
/*==============================================================*/
CREATE TABLE PUB_USER_ROLE
(
   ROLE_COED            VARCHAR(10) NOT NULL COMMENT '��ɫ����',
   DEPART_CODE          VARCHAR(10) COMMENT '���ű���',
   ROLE_NAME            VARCHAR(30) COMMENT '��ɫ����',
   ROLE_SPELL           VARCHAR(30) COMMENT 'ƴ������',
   STATUS               INT NOT NULL COMMENT '״̬',
   PRIMARY KEY (ROLE_COED)
);

ALTER TABLE PUB_USER_ROLE COMMENT '�û���ɫ��';

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

