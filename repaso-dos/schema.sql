create table PROVEEDORES
(
    rut              int not null
        constraint PROVEEDORES_PK
            primary key,
    nombre_proveedor varchar2(50),
    direccion        varchar2(100),
    comuna           varchar2(30)
);

create table ITEM
(
    COD_PRODUCTO    NUMBER not null
        constraint ITEM_PK
            primary key,
    NOMBRE_PRODUCTO VARCHAR2(50),
    STOCK           NUMBER,
    PRECIO          NUMBER,
    RUT_PROVEEDOR   NUMBER
        constraint ITEM_PROVEEDORES_RUT_FK
            references PROVEEDORES
                on delete cascade
);

create table FAENA
(
    ID_FAENA     int
        constraint FAENA_PK
            primary key,
    TITULO       VARCHAR2(100),
    COMUNA       VARCHAR2(30),
    FECHA_INICIO DATE,
    FECHA_FIN    DATE
);

create table DETALLE_FAENA
(
    ID_FAENA     int
        constraint DETALLE_FAENA_ID_FAENA_FK
            references FAENA
                on delete cascade,
    COD_PRODUCTO int
        constraint DETALLE_FAENA_COD_PRODUCTO_FK
            references ITEM
                on delete cascade,
    CANTIDAD     int
);

alter table DETALLE_FAENA
    add constraint pk_detalle_faena
        primary key (ID_FAENA, COD_PRODUCTO);

create sequence faena_seq start with 1;

create trigger faena_tri
    before insert
    on FAENA
    for each row
begin
    select faena_seq.nextval
    into :new.ID_FAENA
    from DUAL;
end;
