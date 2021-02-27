create table estado(
    id bigint not null auto_increment,
    nome varchar(60) not null,
    uf varchar(2) not null,

    primary key(id)
)engine=InnoDB default charset=utf8;

alter table cidade add constraint fk_cidade_estado
foreign key (id_estado) references estado(id);