/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     30-Apr-17 1:35:32 AM                         */
/*==============================================================*/


drop table if exists BARANG;

drop table if exists GUDANG;

drop table if exists PENYEDIA;

drop table if exists PETUGAS;

/*==============================================================*/
/* Table: BARANG                                                */
/*==============================================================*/
create table BARANG
(
   IDBARANG             varchar(4) not null,
   IDPENYEDIA           int,
   IDGUDANG             varchar(4),
   NAMA                 text,
   HARGA                double,
   STOCK                int,
   primary key (IDBARANG)
);

/*==============================================================*/
/* Table: GUDANG                                                */
/*==============================================================*/
create table GUDANG
(
   IDGUDANG             varchar(4) not null,
   LOKASI               text,
   JUMBARANG            int,
   primary key (IDGUDANG)
);

/*==============================================================*/
/* Table: PENYEDIA                                              */
/*==============================================================*/
create table PENYEDIA
(
   IDPENYEDIA           int not null,
   NAMA                 text,
   ALAMAT               text,
   NOHP                 varchar(12),
   JUMBARANG            int,
   primary key (IDPENYEDIA)
);

/*==============================================================*/
/* Table: PETUGAS                                               */
/*==============================================================*/
create table PETUGAS
(
   IDPETUGAS            varchar(4) not null,
   NAMA                 text,
   ALAMAT               text,
   NOHP                 varchar(12),
   EMAIL                text,
   PASSWORD             text,
   primary key (IDPETUGAS)
);
ALTER TABLE `penyedia` CHANGE `IDPENYEDIA` `IDPENYEDIA` INT(11) NOT NULL AUTO_INCREMENT;

alter table BARANG add constraint FK_REFERENCE_1 foreign key (IDPENYEDIA)
      references PENYEDIA (IDPENYEDIA) on delete restrict on update restrict;

alter table BARANG add constraint FK_REFERENCE_2 foreign key (IDGUDANG)
      references GUDANG (IDGUDANG) on delete restrict on update restrict;


