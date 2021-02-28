set foreign_key_checks = 0;

delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupo;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table usuario auto_increment = 1;

insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Argentina');
insert into cozinha (nome) values ('Brasileira');

insert into estado (id, nome, uf) values (1, 'Acre', 'AC');
insert into estado (id, nome, uf) values (2, 'Alagoas', 'AL');
insert into estado (id, nome, uf) values (3, 'Amazonas', 'AM');
insert into estado (id, nome, uf) values (4, 'Amapá', 'AP');
insert into estado (id, nome, uf) values (5, 'Bahia', 'BA');
insert into estado (id, nome, uf) values (6, 'Ceará', 'CE');
insert into estado (id, nome, uf) values (7, 'Distrito Federal', 'DF');
insert into estado (id, nome, uf) values (8, 'Espírito Santo', 'ES');
insert into estado (id, nome, uf) values (9, 'Goiás', 'GO');
insert into estado (id, nome, uf) values (10, 'Maranhão', 'MA');
insert into estado (id, nome, uf) values (11, 'Minas Gerais', 'MG');
insert into estado (id, nome, uf) values (12, 'Mato Grosso do Sul', 'MS');
insert into estado (id, nome, uf) values (13, 'Mato Grosso', 'MT');
insert into estado (id, nome, uf) values (14, 'Pará', 'PA');
insert into estado (id, nome, uf) values (15, 'Paraíba', 'PB');
insert into estado (id, nome, uf) values (16, 'Pernambuco', 'PE');
insert into estado (id, nome, uf) values (17, 'Piauí', 'PI');
insert into estado (id, nome, uf) values (18, 'Paraná', 'PR');
insert into estado (id, nome, uf) values (19, 'Rio de Janeiro', 'RJ');
insert into estado (id, nome, uf) values (20, 'Rio Grande do Norte', 'RN');
insert into estado (id, nome, uf) values (21, 'Rondônia', 'RO');
insert into estado (id, nome, uf) values (22, 'Roraima', 'RR');
insert into estado (id, nome, uf) values (23, 'Rio Grande do Sul', 'RS');
insert into estado (id, nome, uf) values (24, 'Santa Catarina', 'SC');
insert into estado (id, nome, uf) values (25, 'Sergipe', 'SE');
insert into estado (id, nome, uf) values (26, 'São Paulo', 'SP');
insert into estado (id, nome, uf) values (27, 'Tocantins', 'TO');

insert into cidade (id, nome, id_estado) values (1, 'Araguari', 11);
insert into cidade (id, nome, id_estado) values (2, 'Belo Horizonte', 11);
insert into cidade (id, nome, id_estado) values (3, 'São Paulo', 26);
insert into cidade (id, nome, id_estado) values (4, 'Campinas', 26);
insert into cidade (id, nome, id_estado) values (5, 'Fortaleza', 6);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante (id, nome, taxa_frete, cozinha_id, end_cidade_id, end_cep, end_logradouro, end_numero, end_bairro, data_cadastro, data_atualizacao) values (1, 'Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro', utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4, 'Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (5, 'Lanchonete do Tio Sam', 11, 4, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (6, 'Bar da Maria', 6, 4, utc_timestamp, utc_timestamp);

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 2);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 3);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (2, 3);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (3, 2);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (3, 3);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (4, 1);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (4, 2);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (5, 1);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (5, 2);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (6, 3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);