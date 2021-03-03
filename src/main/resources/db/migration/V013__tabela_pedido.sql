create table pedido (
    id bigint not null auto_increment,
    subtotal decimal(10,2) not null,
    taxa_frete decimal(10,2) not null,
    valor_total decimal(10,2) not null,
    restaurante_id bigint not null,
    usuario_cliente_id bigint not null,
    forma_pagamento_id bigint not null,
    end_cidade_id bigint(20) not null,
    end_cep varchar(9) not null,
    end_logradouro varchar(100) not null,
    end_numero varchar(20) not null,
    end_complemento varchar(60) null,
    end_bairro varchar(60) not null,
    status varchar(10) not null,
    data_criacao datetime not null,
    data_confirmacao datetime null,
    data_cancelamento datetime null,
    data_entrega datetime null,

    primary key (id)
) engine=InnoDB default charset=utf8;

alter table pedido add constraint fk_pedido_endereco_cidade
foreign key (end_cidade_id) references cidade (id);

alter table pedido add constraint fk_pedido_restaurante
foreign key (restaurante_id) references restaurante (id);

alter table pedido add constraint fk_pedido_usuario_cliente
foreign key (usuario_cliente_id) references usuario (id);

alter table pedido add constraint fk_pedido_forma_pagamento
foreign key (forma_pagamento_id) references forma_pagamento (id);