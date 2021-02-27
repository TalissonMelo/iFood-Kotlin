create table restaurante (
	id bigint not null auto_increment,
	cozinha_id bigint not null,
	nome varchar(80) not null,
	taxa_frete decimal(10,2) not null,
	data_atualizacao datetime not null,
	data_cadastro datetime not null,

	end_cidade_id bigint,
	end_cep varchar(9),
	end_logradouro varchar(100),
	end_numero varchar(20),
	end_complemento varchar(60),
	end_bairro varchar(60),

	primary key (id)
) engine=InnoDB default charset=utf8;

alter table restaurante add constraint fk_restaurante_cozinha
foreign key (cozinha_id) references cozinha (id);

alter table restaurante add constraint fk_restaurante_cidade
foreign key (end_cidade_id) references cidade (id);