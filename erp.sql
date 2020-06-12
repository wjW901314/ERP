create table if not exists business_commodity_management
(
    id                 varchar(10)   not null
        primary key,
    COMMODITY_NAME     varchar(50)   null comment '商品名称',
    COMMODITY_SPELL    varchar(50)   null comment '拼音码',
    COMMODITY_SPEC     int           not null comment '规格',
    COMMODITY_SUPPLIER int           not null comment '供应商',
    STATUS             int default 0 not null comment '状态'
);

create table if not exists business_commodity_outbound
(
    id                varchar(10)   not null comment 'ID'
        primary key,
    COMMODITY_ID      varchar(10)   not null comment '商品ID',
    DELIVERY_QUANTITY int default 0 not null comment '出库数量',
    ISSUE_DATE        datetime      not null comment '出库日期',
    OPERATOR          varchar(10)   not null comment '操作人员',
    STATUS            int default 0 not null comment '状态 0 未审核 1 审核 2 作废'
);

create table if not exists business_commodity_warehousing
(
    id                varchar(10)   not null comment 'id'
        primary key,
    COMMODITY_ID      varchar(10)   not null comment '商品ID',
    PURCHASE_QUANTITY int default 0 not null comment '采购数量',
    WAREHOUSING_DATE  datetime      not null comment '入库日期',
    OPERATOR          varchar(10)   not null comment '操作人员',
    STATUS            int default 0 not null comment '状态 0 未审核 1 审核 2 作废'
);

create table if not exists pub_basis_supplier
(
    id             int           not null
        primary key,
    SUPPLIER_NAME  varchar(100)  null comment '供应商名称',
    SUPPLIER_SPELL varchar(100)  null comment '拼音简码',
    PHONE          varchar(20)   null comment '联系方式',
    STATUS         int default 0 not null comment '状态'
)
    comment '供应商';

create table if not exists pub_basis_user_info
(
    ID         varchar(10)   not null comment '用户编码'
        primary key,
    USER_NAME  varchar(30)   null comment '用户名称',
    USER_SPELL varchar(30)   null comment '拼音简码',
    PHONE      varchar(30)   null comment '手机号码',
    EMAIL      varchar(50)   null comment '电子邮件',
    ROLE       int default 0 not null comment '角色',
    STATUS     int default 0 not null comment '状态',
    PASSWORD   varchar(30)   null comment '密码'
);



create table pub_client_info
(
    CODE    varchar(30)  not null comment '客户编码'
        primary key,
    NAME    varchar(100) null comment '客户名称',
    SPELL   varchar(100) null comment '拼音简码',
    PERSON  varchar(30)  null comment '负责人',
    PHONE   varchar(20)  null comment '联系方式',
    EMAIL   varchar(100) null comment '电子邮件',
    REMARKS text         null comment '备注',
    STATUS  int          not null comment '状态'
)
    comment '客户信息表';

create table pub_commodity_spec
(
    SPEC_CODE  varchar(30)  not null comment '规格编码'
        primary key,
    SPEC_NAME  varchar(100) null comment '规格名称',
    SPEC_SPELL varchar(100) null comment '拼音简码',
    STATUS     int          not null comment '状态'
)
    comment '商品规格表';

create table pub_commodity_type
(
    TYPE_CODE varchar(10) not null comment '类型编码'
        primary key,
    TYPE_NAME varchar(30) null comment '类型名称',
    SPELL     varchar(30) null comment '拼音简码',
    STATUS    int         not null comment '状态'
)
    comment '商品类型表';

create table pub_department
(
    DEPART_CODE  varchar(10)  not null comment '部门编码'
        primary key,
    DEPART_NAME  varchar(30)  null comment '部门名称',
    DEPART_SPELL varchar(100) null comment '拼音简码',
    REMARKS      text         null comment '简介',
    STATUS       int          not null comment '状态'
)
    comment '部门信息表';

create table pub_supplier_info
(
    CODE    varchar(30)  not null comment '供应商编码'
        primary key,
    NAME    varchar(30)  null comment '供应商名称',
    SPELL   varchar(30)  null comment '拼音简码',
    ADDERS  varchar(200) null comment '地址',
    PHONE   varchar(20)  null comment '联系方式',
    EMAIL   varchar(200) null comment '电子邮件',
    REMARKS text         null comment '备注',
    STATUS  int          not null comment '状态'
)
    comment '供应商信息表';

create table pub_unit
(
    UNIT_CODE  varchar(30) not null comment '单位编码'
        primary key,
    UNIT_NAME  varchar(30) null comment '单位名称',
    UNIT_SPELL varchar(30) null comment '拼音简码',
    STATUS     int         not null comment '状态'
)
    comment '计量单位表';

create table pub_commodity_info
(
    COMMODITY_CODE varchar(30)   not null comment '商品编码'
        primary key,
    SPEC_CODE      varchar(30)   not null comment '规格编码',
    UNIT_CODE      varchar(30)   null comment '计量单位',
    TYPE_CODE      varchar(10)   not null comment '类型编码',
    SUPPLIER_CODE  varchar(10)   not null comment '供应商',
    REMARKS        text          null comment '备注',
    STATUS         int default 0 not null comment '状态',
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

create table business_commodity_purchase
(
    ID              varchar(30)    not null comment 'ID'
        primary key,
    COMMODITY_CODE  varchar(30)    null comment '商品编码',
    CODE            varchar(30)    null comment '供应商编码',
    PURCHASING_COST decimal(10, 2) null comment '进货成本',
    PURCHASE_PRICE  decimal(5, 2)  null comment '进货价格',
    SELLING_PRICE   decimal(5, 2)  null comment '销售价格',
    PURCHASE_NUMBER int            null comment '进货数量',
    PURCHASE_DATE   date           null comment '进货日期',
    STATUS          int            not null comment '状态',
    constraint FK_PURCHASE_COMMODITY
        foreign key (COMMODITY_CODE) references pub_commodity_info (COMMODITY_CODE),
    constraint FK_PURCHASE_SUPPLIER
        foreign key (CODE) references pub_supplier_info (CODE)
)
    comment '商品进货表';

create table business_commodity_sale
(
    ID             varchar(30)   not null comment 'ID'
        primary key,
    COMMODITY_CODE varchar(30)   null comment '商品编码',
    COMMODITY_NAME varchar(100)  null comment '商品名称',
    SALE_NUMBER    int           null comment '销售数量',
    SALE_PRICE     decimal(5, 2) null comment '销售价格',
    CLIENT_CODE    varchar(30)   null comment '客户编码',
    SALE_PERSON    varchar(10)   null comment '销售人员',
    SALE_DATE      date          null comment '销售日期',
    REMARKS        text          null comment '备注',
    STATUS         int           not null comment '状态',
    constraint FK_CLIENT_COMMODITY_SALE
        foreign key (CLIENT_CODE) references pub_client_info (CODE),
    constraint FK_COMMODITY_SALE_CODE
        foreign key (COMMODITY_CODE) references pub_commodity_info (COMMODITY_CODE)
)
    comment '商品销售表';

create table business_commodity_stock
(
    ID                varchar(30)    not null comment 'ID'
        primary key,
    COMMODITY_CODE    varchar(30)    null comment '商品编码',
    LARGE_UNIT        varchar(10)    null comment '大单位',
    SMALL_UNIT        varchar(10)    null comment '小单位',
    SPEC_CODE         varchar(30)    null comment '商品规格',
    TOTAL_PRICE       decimal(10, 2) null comment '总价',
    INVENTORY         int            null comment '库存量',
    PRICE             decimal(5, 2)  null comment '单价',
    MINIMUM_INVENTORY int            null comment '最低库存量',
    constraint FK_COMMODITY_STOCK_CODE
        foreign key (COMMODITY_CODE) references pub_commodity_info (COMMODITY_CODE)
)
    comment '商品库存表';

create table pub_user_role
(
    ROLE_COED   varchar(10) not null comment '角色编码'
        primary key,
    DEPART_CODE varchar(10) null comment '部门编码',
    ROLE_NAME   varchar(30) null comment '角色名称',
    ROLE_SPELL  varchar(30) null comment '拼音简码',
    STATUS      int         not null comment '状态',
    constraint FK_USER_ROLE_DEPART_CODE
        foreign key (DEPART_CODE) references pub_department (DEPART_CODE)
)
    comment '用户角色表';

create table pub_userinfo
(
    USER_CODE   varchar(10) not null comment '用户编码'
        primary key,
    DEPART_CODE varchar(10) null comment '部门编码',
    ROLE_COED   varchar(10) null comment '角色编码',
    USER_NAME   varchar(30) null comment '用户名称',
    USER_SPELL  varchar(30) null comment '拼音简码',
    PASSWORD    varchar(30) null comment '密码',
    STATUS      int         not null comment '状态',
    constraint FK_USERINFO_DEPART_CODE
        foreign key (DEPART_CODE) references pub_department (DEPART_CODE),
    constraint FK_USER_ROLE_CODE
        foreign key (ROLE_COED) references pub_user_role (ROLE_COED)
)
    comment '用户信息表';

create table pub_user_power
(
    POWER_CODE  varchar(10) not null comment '权限编码'
        primary key,
    USER_CODE   varchar(10) null comment '用户编码',
    ROLE_CODE   varchar(10) null comment '角色编码',
    POWER_NAME  varchar(30) null comment '权限名称',
    POWER_SPELL varchar(30) null comment '拼音简码',
    constraint FK_USER_RIGTHS_CODE
        foreign key (USER_CODE) references pub_userinfo (USER_CODE),
    constraint FK_USER_RIGTHS_ROLE_CODE
        foreign key (ROLE_CODE) references pub_user_role (ROLE_COED)
)
    comment '用户权限表';

