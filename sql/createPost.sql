
create table tbl_post(
  pono number(10, 0),
  title varchar2(200) not null,
  text varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate,
  updatedate date default sysdate
);

alter table tbl_post add constraint pk_post
primary key (pono);

create sequence seq_post;
